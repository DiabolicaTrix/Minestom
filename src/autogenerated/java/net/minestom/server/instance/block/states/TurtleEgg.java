package net.minestom.server.instance.block.states;
import net.minestom.server.instance.block.BlockAlternative;
import static net.minestom.server.instance.block.Block.*;
/**
 * Completely internal. DO NOT USE. IF YOU ARE A USER AND FACE A PROBLEM WHILE USING THIS CODE, THAT'S ON YOU.
 */
@Deprecated(forRemoval = false, since = "forever")
public class TurtleEgg {
	public static void initStates() {
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9498, "eggs=1", "hatch=0"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9499, "eggs=1", "hatch=1"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9500, "eggs=1", "hatch=2"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9501, "eggs=2", "hatch=0"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9502, "eggs=2", "hatch=1"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9503, "eggs=2", "hatch=2"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9504, "eggs=3", "hatch=0"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9505, "eggs=3", "hatch=1"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9506, "eggs=3", "hatch=2"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9507, "eggs=4", "hatch=0"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9508, "eggs=4", "hatch=1"));
		TURTLE_EGG.addBlockAlternative(new BlockAlternative((short) 9509, "eggs=4", "hatch=2"));
	}
}
