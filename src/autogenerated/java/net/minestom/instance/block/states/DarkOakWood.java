package net.minestom.instance.block.states;
import net.minestom.server.instance.block.BlockAlternative;
import static net.minestom.instance.block.TmpBlock.*;
/**
 * Completely internal. DO NOT USE. IF YOU ARE A USER AND FACE A PROBLEM WHILE USING THIS CODE, THAT'S ON YOU.
 */
@Deprecated(forRemoval = false, since = "forever")
public class DarkOakWood {
	public static void initStates() {
		DARK_OAK_WOOD.addBlockAlternative(new BlockAlternative((short) 123, "axis=x"));
		DARK_OAK_WOOD.addBlockAlternative(new BlockAlternative((short) 124, "axis=y"));
		DARK_OAK_WOOD.addBlockAlternative(new BlockAlternative((short) 125, "axis=z"));
	}
}