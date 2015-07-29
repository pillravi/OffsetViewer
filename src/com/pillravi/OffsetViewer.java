package com.pillravi;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.EditorFactory;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by lily on 7/28/15.
 */
public class OffsetViewer implements ApplicationComponent,
        PersistentStateComponent<Element> {

    private static final String OFFSET_VIEWER_COMPONENT_NAME = "OffsetViewerPlugin";
    private static final Logger LOG = Logger.getInstance(OffsetViewer.class);

    @Override
    public void initComponent() {
        LOG.debug("initComponent");

        EditorFactory.getInstance().getEventMulticaster()
                .addCaretListener(new MyCaretListener());


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
        System.out.println("loadState");
    }
}
