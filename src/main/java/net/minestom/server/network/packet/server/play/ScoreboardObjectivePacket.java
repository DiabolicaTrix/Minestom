package net.minestom.server.network.packet.server.play;

import net.minestom.server.chat.ColoredText;
import net.minestom.server.network.packet.PacketWriter;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;

public class ScoreboardObjectivePacket implements ServerPacket {

    /**
     * An unique name for the objective
     */
    public String objectiveName;
    /**
     * 0 = create the scoreboard <br>
     * 1 = to remove the scoreboard<br>
     * 2 = to update the display text
     */
    public byte mode;
    /**
     * The text to be displayed for the score
     */
    public ColoredText objectiveValue;
    /**
     * The type how the score is displayed
     */
    public Type type;

    @Override
    public void write(PacketWriter writer) {
        writer.writeSizedString(objectiveName);
        writer.writeByte(mode);

        if (mode == 0 || mode == 2) {
            writer.writeSizedString(objectiveValue.toString());
            writer.writeVarInt(type.ordinal());
        }
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.SCOREBOARD_OBJECTIVE;
    }

    /**
     * This enumeration represents all available types for the scoreboard objective
     */
    public enum Type {
        INTEGER,
        HEARTS
    }
}
