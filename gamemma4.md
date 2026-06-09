# Ollama 服务重启与调试指南 (OpenCyvis)

本指南用于管理和调试 Ollama 服务及其运行的 `gemma4:26b-a4b-it-q4_K_M` 模型。

---

## 1. 查看当前 Ollama 状态

确认当前显存中是否已加载模型：
```bash
ollama ps
```
如果输出如下内容，说明模型仍在运行：
`NAME: gemma4:26b-a4b-it-q4_K_M`

---

## 2. 停止当前模型

手动卸载模型以释放显存：
```bash
ollama stop gemma4:26b-a4b-it-q4_K_M
```
再次运行 `ollama ps` 确认列表为空。

---

## 3. 检查 Ollama 服务进程

即使模型停止，Ollama 的后台服务（Server）可能仍在运行。

### 检查端口占用 (11434)
```bash
lsof -i :11434
```

### 查看具体进程 PID
```bash
ps aux | grep ollama
```
通常你会看到类似 `/Applications/Ollama.app/Contents/Resources/ollama serve` 的进程。

---

## 4. 彻底关闭 Ollama 服务

获取到 PID（例如 `21120`）后，终止该进程：
```bash
kill 21120
```
如果进程无响应，请使用强制停止：
```bash
kill -9 21120
```
**验证：** 再次执行 `lsof -i :11434`，确保没有任何输出。

---

## 5. 启动 Debug 模式

在终端中带环境变量启动，以便实时观察推理细节。**启动前请确保已退出菜单栏中的 Ollama 图标应用。**

```bash
OLLAMA_HOST=0.0.0.0:11434 OLLAMA_DEBUG=1 ollama serve
```
*请保持此终端窗口开启，以便查看后续日志。*

---

## 6. 验证服务是否正常

新开一个终端，检查 API 响应：
```bash
curl http://localhost:11434/api/tags
```
应返回包含 `gemma4:26b-a4b-it-q4_K_M` 的模型列表。

---

## 7. 验证 OpenCyvis 连接

在手机端发起操作指令（如“打开微信”），观察 `ollama serve` 所在的终端。
如果出现 `POST /api/chat`，说明手机端已成功连通服务端。

---

## 8. 查看详细推理日志

在 `OLLAMA_DEBUG=1` 模式下，关注以下关键日志：
- `POST /completion`: 接收到推理请求。
- `processing image`: 正在处理传输过来的屏幕截图。
- `prompt eval time`: 提示词预处理（Prefill）耗时。
- `eval time`: Token 生成（Decode）耗时。

通过这些日志可以判断：是否识别到了界面、是否生成了对应的动作 JSON、是否陷入了重复步骤。

---

## 9. 常见问题 (FAQ)

- **问题1：启动报错 `bind: address already in use`**
  - 原因：11434 端口已被旧进程占用。
  - 解决：使用 `lsof` 查杀旧 PID 后重新启动。
- **问题2：模型一直运行不退出**
  - 解决：执行 `ollama stop gemma4:26b-a4b-it-q4_K_M`。
- **问题3：OpenCyvis 显示已完成，但手机无实际反应**
  - 解决：检查 `OLLAMA_DEBUG` 输出看是否生成了合法的 `action_type`；同时检查手机端的 `AgentService` 日志确认 Action 是否被成功执行。

---

## 10. 推荐的完整重启流程

遇到异常时，建议按以下标准化顺序操作：

1. **卸载模型**：`ollama stop gemma4:26b-a4b-it-q4_K_M`
2. **清理环境**：使用 `lsof` 找到并 `kill` 掉残留的 ollama 进程。
3. **确认释放**：再次 `lsof -i :11434` 确保端口干净。
4. **Debug 启动**：`OLLAMA_HOST=0.0.0.0:11434 OLLAMA_DEBUG=1 ollama serve`
5. **连通测试**：使用 `curl` 验证后，重新在手机端发起任务。
