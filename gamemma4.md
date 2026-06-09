# Gemma4 (Ollama) 使用指南

本文件记录了在 macOS 上使用 Ollama 管理 `gemma4:26b-a4b-it-q4_K_M` 模型的基本命令。

## 1. 启动模型
使用以下命令运行并进入交互界面：
```bash
ollama run gemma4:26b-a4b-it-q4_K_M
```

## 2. 停止模型
若需主动停止正在运行的模型（释放显存）：
```bash
ollama stop gemma4:26b-a4b-it-q4_K_M
```

## 3. 调试模式与查看日志
在 macOS 上，可以通过以下几种方式查看详细运行信息：

### A. 环境变量启动调试服务
首先退出菜单栏中的 Ollama 应用，然后在终端中运行：
```bash
OLLAMA_DEBUG=1 ollama serve
```
这将会在终端直接输出详细的调试日志。

### B. 查看系统日志文件
Ollama 的日志默认存储在用户目录下，可以使用 `tail` 命令实时查看：
```bash
tail -f ~/.ollama/logs/server.log
```

### C. 检查模型状态
查看当前已加载到内存的模型：
```bash
ollama ps
```
