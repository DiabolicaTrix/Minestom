package net.minestom.server.network.packet.server.play;

import net.minestom.server.network.packet.PacketWriter;
import net.minestom.server.network.packet.server.ServerPacket;
import net.minestom.server.network.packet.server.ServerPacketIdentifier;

public class EntityVelocityPacket implements ServerPacket {

    public int entityId;
    public short velocityX, velocityY, velocityZ;

    @Override
    public void write(PacketWriter writer) {
        writer.writeVarInt(entityId);
        writer.writeShort(velocityX);
        writer.writeShort(velocityY);
        writer.writeShort(velocityZ);
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.ENTITY_VELOCITY;
    }
}
