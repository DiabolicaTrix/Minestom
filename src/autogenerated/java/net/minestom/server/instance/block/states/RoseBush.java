package net.minestom.server.instance.block.states;
import net.minestom.server.instance.block.BlockAlternative;
import static net.minestom.server.instance.block.Block.*;
/**
 * Completely internal. DO NOT USE. IF YOU ARE A USER AND FACE A PROBLEM WHILE USING THIS CODE, THAT'S ON YOU.
 */
@Deprecated(forRemoval = false, since = "forever")
public class RoseBush {
	public static void initStates() {
		ROSE_BUSH.addBlockAlternative(new BlockAlternative((short) 7889, "half=upper"));
		ROSE_BUSH.addBlockAlternative(new BlockAlternative((short) 7890, "half=lower"));
	}
}
