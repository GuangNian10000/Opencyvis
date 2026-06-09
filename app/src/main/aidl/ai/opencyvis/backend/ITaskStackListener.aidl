package ai.opencyvis.backend;

import android.content.ComponentName;

interface ITaskStackListener {
    void onTaskMovedToFront(int taskId, int displayId, String topPackage);
    void onTaskDisplayChanged(int taskId, int newDisplayId);
    void onTaskCreated(int taskId, String packageName);
    void onTaskRemoved(int taskId);
}
