package com.pillravi;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.event.CaretEvent;
import com.intellij.openapi.editor.event.CaretListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import org.jetbrains.annotations.Nullable;

/**
 * Created by lily on 7/28/15.
 */
public class MyCaretListener implements CaretListener {
    @Override
    public void caretPositionChanged(CaretEvent e) {
        Editor editor = e.getEditor();

        LogicalPosition lp = e.getNewPosition();
        Integer offset = editor.logicalPositionToOffset(lp);
        showMessage(offset.toString());
    }

    @Override
    public void caretAdded(CaretEvent e) {

    }

    @Override
    public void caretRemoved(CaretEvent e) {

    }

    private void showMessage(@Nullable String msg) {
        ProjectManager pm = ProjectManager.getInstance();
        Project[] projects = pm.getOpenProjects();
        for (Project project : projects) {
            StatusBar bar = WindowManager.getInstance().getStatusBar(project);
            if (bar != null) {
                if (msg == null || msg.length() == 0) {
                    bar.setInfo("");
                }
                else {
                    bar.setInfo("Offset: " + msg);
                }
            }
        }
    }
}
