package com.pillravi;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.jvm.hotspot.ui.EditorFactory;

/**
 * Created by lily on 7/28/15.
 */
public class OffsetViewer implements ApplicationComponent,
        PersistentStateComponent<Element> {

    private static final String OFFSET_VIEWER_COMPONENT_NAME = "OffsetViewerPlugin";

    private static final Logger LOG = Logger.getInstance(OffsetViewer.class);

    public static void showMessage(@Nullable String msg) {
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

    @Override
    public void initComponent() {
        LOG.debug("initComponent");
        EditorFactory.
        LOG.debug("done");
    }

    @Override
    public void disposeComponent() {
        LOG.debug("disposeComponent");
        LOG.debug("done");
    }

    @NotNull
    @Override
    public String getComponentName() {
        return OFFSET_VIEWER_COMPONENT_NAME;
    }

    @Nullable
    @Override
    public Element getState() {
        return null;
    }

    @Override
    public void loadState(Element state) {

    }
}
