package net.minestom.instance.block.states;
import net.minestom.server.instance.block.BlockAlternative;
import static net.minestom.instance.block.TmpBlock.*;
/**
 * Completely internal. DO NOT USE. IF YOU ARE A USER AND FACE A PROBLEM WHILE USING THIS CODE, THAT'S ON YOU.
 */
@Deprecated(forRemoval = false, since = "forever")
public class PlayerWallHead {
	public static void initStates() {
		PLAYER_WALL_HEAD.addBlockAlternative(new BlockAlternative((short) 6030, "facing=north"));
		PLAYER_WALL_HEAD.addBlockAlternative(new BlockAlternative((short) 6031, "facing=south"));
		PLAYER_WALL_HEAD.addBlockAlternative(new BlockAlternative((short) 6032, "facing=west"));
		PLAYER_WALL_HEAD.addBlockAlternative(new BlockAlternative((short) 6033, "facing=east"));
	}
}