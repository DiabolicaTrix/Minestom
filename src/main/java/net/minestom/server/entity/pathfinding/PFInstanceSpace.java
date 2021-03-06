package net.minestom.server.entity.pathfinding;

import com.extollit.gaming.ai.path.model.IBlockObject;
import com.extollit.gaming.ai.path.model.IColumnarSpace;
import com.extollit.gaming.ai.path.model.IInstanceSpace;
import net.minestom.server.instance.Chunk;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PFInstanceSpace implements IInstanceSpace {

    private Instance instance;
    private Map<Chunk, PFColumnarSpace> chunkSpaceMap = new ConcurrentHashMap<>();

    public PFInstanceSpace(Instance instance) {
        this.instance = instance;
    }

    @Override
    public IBlockObject blockObjectAt(int x, int y, int z) {
        final short blockStateId = instance.getBlockStateId(x, y, z);
        final Block block = Block.fromStateId(blockStateId);
        return new PFBlockObject(block);
    }

    @Override
    public IColumnarSpace columnarSpaceAt(int cx, int cz) {
        final Chunk chunk = instance.getChunk(cx, cz);
        if (chunk == null) {
            return null;
        }

        final PFColumnarSpace columnarSpace =
                chunkSpaceMap.computeIfAbsent(chunk, c -> {
                    final PFColumnarSpace cs = new PFColumnarSpace(this, c);
                    c.setColumnarSpace(cs);
                    return cs;
                });

        return columnarSpace;
    }

    public Instance getInstance() {
        return instance;
    }
}
