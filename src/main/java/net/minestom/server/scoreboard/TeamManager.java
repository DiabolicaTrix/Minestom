package net.minestom.server.scoreboard;

import net.minestom.server.MinecraftServer;
import net.minestom.server.chat.ChatColor;
import net.minestom.server.chat.ColoredText;
import net.minestom.server.entity.Player;
import net.minestom.server.network.PacketWriterUtils;
import net.minestom.server.network.packet.server.ServerPacket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * An object which manages all the {@link Team}'s
 */
public final class TeamManager {

    /**
     * Represents all registered teams
     */
    private final Set<Team> teams;

    /**
     * Default constructor
     */
    public TeamManager() {
        this.teams = new CopyOnWriteArraySet<>();
    }

    /**
     * Registers a new {@link Team}
     *
     * @param team The team to be registered
     */
    protected void registerNewTeam(Team team) {
        this.teams.add(team);
        this.broadcastPacket(team.getTeamsCreationPacket());
    }

    /**
     * Initializes a new {@link TeamBuilder} for creating a team
     *
     * @param name The registry name of the team
     * @return the team builder
     */
    public TeamBuilder createBuilder(String name) {
        return new TeamBuilder(name, this);
    }

    /**
     * Creates a {@link Team} with only the registry name
     *
     * @param name The registry name
     * @return the created {@link Team}
     */
    public Team createTeam(String name) {
        return this.createBuilder(name).build();
    }

    /**
     * Creates a {@link Team} with the registry name, prefix, suffix and the team color
     *
     * @param name      The registry name
     * @param prefix    The team prefix
     * @param teamColor The team color
     * @param suffix    The team suffix
     * @return the created {@link Team} with a prefix, teamColor and suffix
     */
    public Team createTeam(String name, ColoredText prefix, ChatColor teamColor, ColoredText suffix) {
        return this.createBuilder(name).prefix(prefix).teamColor(teamColor).suffix(suffix).updateTeamPacket().build();
    }

    /**
     * Creates a {@link Team} with the registry name, display name, prefix, suffix and the team colro
     *
     * @param name        The registry name
     * @param displayName The display name
     * @param prefix      The team prefix
     * @param teamColor   The team color
     * @param suffix      The team suffix
     * @return the created {@link Team} with a prefix, teamColor, suffix and the display name
     */
    public Team createTeam(String name, ColoredText displayName, ColoredText prefix, ChatColor teamColor, ColoredText suffix) {
        return this.createBuilder(name).teamDisplayName(displayName).prefix(prefix).teamColor(teamColor).suffix(suffix).updateTeamPacket().build();
    }

    /**
     * Gets a {@link Team} with the given name
     *
     * @param teamName The registry name of the team
     * @return a registered {@link Team} or {@code null}
     */
    public Team getTeam(String teamName) {
        for (Team team : this.teams) {
            if (team.getTeamName().equals(teamName)) return team;
        }
        return null;
    }

    /**
     * Checks if the given name a registry name of a registered {@link Team}
     *
     * @param teamName The name of the team
     * @return {@code true} if the team is registered, otherwise {@code false}
     */
    public boolean exists(String teamName) {
        for (Team team : this.teams) {
            if (team.getTeamName().equals(teamName)) return true;
        }
        return false;
    }

    /**
     * Checks if the given {@link Team} registered
     *
     * @param team The searched team
     * @return {@code true} if the team is registered, otherwise {@code false}
     */
    public boolean exists(Team team) {
        return this.exists(team.getTeamName());
    }

    /**
     * Gets a {@link Set} with all registered {@link Team}'s
     *
     * @return a {@link Set} with all registered {@link Team}'s
     */
    public Set<Team> getTeams() {
        return this.teams;
    }

    /**
     * Broadcasts to all online {@link Player}'s a {@link ServerPacket}
     *
     * @param packet The packet to broadcast
     */
    private void broadcastPacket(ServerPacket packet) {
        PacketWriterUtils.writeAndSend(MinecraftServer.getConnectionManager().getOnlinePlayers(), packet);
    }
}
