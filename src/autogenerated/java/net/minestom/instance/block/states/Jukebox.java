package net.minestom.instance.block.states;
import net.minestom.server.instance.block.BlockAlternative;
import static net.minestom.instance.block.TmpBlock.*;
/**
 * Completely internal. DO NOT USE. IF YOU ARE A USER AND FACE A PROBLEM WHILE USING THIS CODE, THAT'S ON YOU.
 */
@Deprecated(forRemoval = false, since = "forever")
public class Jukebox {
	public static void initStates() {
		JUKEBOX.addBlockAlternative(new BlockAlternative((short) 3962, "has_record=true"));
		JUKEBOX.addBlockAlternative(new BlockAlternative((short) 3963, "has_record=false"));
	}
}