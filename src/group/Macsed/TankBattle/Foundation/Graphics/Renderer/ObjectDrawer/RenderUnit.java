package group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer;

import group.Macsed.TankBattle.Foundation.Graphics.Data.RenderDataUnit;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.GraphicBaseDrawer;
import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Random;

import static org.lwjgl.system.MemoryStack.stackPush;

public class RenderUnit {

    public String unitTag;
    private RenderDataUnit data;

    private boolean hasSub = false;
    private RenderDataUnit subData;

    public void setData(RenderDataUnit data) {
        this.data = data;
    }

    public void setSubData(RenderDataUnit subData) {
        this.subData = subData;
    }


    public void setHasSub(boolean hasSub) {
        this.hasSub = hasSub;
    }

    public void render(){

        try (MemoryStack stack = stackPush() ) {

            FloatBuffer vertices;
            IntBuffer indices;

            vertices = stack.mallocFloat(4 * 5);
            vertices.put(data.width+data.Xposition).put(data.height+data.Yposition).put(0f).put(1.0f).put(1.0f);
            vertices.put(data.width+data.Xposition).put(-data.height+data.Yposition).put(0f).put(1.0f).put(0.0f);
            vertices.put(-data.width+data.Xposition).put(-data.height+data.Yposition).put(0f).put(0.0f).put(0.0f);
            vertices.put(-data.width+data.Xposition).put(data.height+data.Yposition).put(0f).put(0.0f).put(1.0f);
            vertices.flip();

            indices = stack.mallocInt(2 * 3);
            indices.put(0).put(1).put(3);
            indices.put(1).put(2).put(3);
            indices.flip();

            GraphicBaseDrawer.shared.setIndices(indices);
            GraphicBaseDrawer.shared.setVertices(vertices);
            GraphicBaseDrawer.shared.setTexturePath(data.path);
            GraphicBaseDrawer.shared.draw();



        }


    }




}
