package net.minestom.server.entity.pathfinding;

import com.extollit.gaming.ai.path.model.ColumnarOcclusionFieldList;
import com.extollit.gaming.ai.path.model.IBlockDescription;
import com.extollit.gaming.ai.path.model.IColumnarSpace;
import com.extollit.gaming.ai.path.model.IInstanceSpace;
import net.minestom.server.instance.Chunk;
import net.minestom.server.instance.block.Block;

public class PFColumnarSpace implements IColumnarSpace {

    private final ColumnarOcclusionFieldList occlusionFieldList = new ColumnarOcclusionFieldList(this);
    private PFInstanceSpace instanceSpace;
    private Chunk chunk;


    public PFColumnarSpace(PFInstanceSpace instanceSpace, Chunk chunk) {
        this.instanceSpace = instanceSpace;
        this.chunk = chunk;
    }

    @Override
    public IBlockDescription blockAt(int x, int y, int z) {
        final short blockStateId = chunk.getBlockStateId(x, y, z);
        final Block block = Block.fromStateId(blockStateId);
        return new PFBlockDescription(block);
    }

    @Override
    public int metaDataAt(int x, int y, int z) {
        return 0;
    }

    @Override
    public ColumnarOcclusionFieldList occlusionFields() {
        return occlusionFieldList;
    }

    @Override
    public IInstanceSpace instance() {
        return instanceSpace;
    }
}
