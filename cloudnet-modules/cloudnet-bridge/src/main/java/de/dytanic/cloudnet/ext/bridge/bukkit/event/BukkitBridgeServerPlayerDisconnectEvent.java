package de.dytanic.cloudnet.ext.bridge.bukkit.event;

import de.dytanic.cloudnet.ext.bridge.player.NetworkConnectionInfo;
import de.dytanic.cloudnet.ext.bridge.player.NetworkPlayerServerInfo;
import org.bukkit.event.HandlerList;

public final class BukkitBridgeServerPlayerDisconnectEvent extends BukkitBridgeEvent {

    private static HandlerList handlerList = new HandlerList();
    private final NetworkConnectionInfo networkConnectionInfo;
    private final NetworkPlayerServerInfo networkPlayerServerInfo;

    public BukkitBridgeServerPlayerDisconnectEvent(NetworkConnectionInfo networkConnectionInfo, NetworkPlayerServerInfo networkPlayerServerInfo) {
        this.networkConnectionInfo = networkConnectionInfo;
        this.networkPlayerServerInfo = networkPlayerServerInfo;
    }

    public static HandlerList getHandlerList() {
        return BukkitBridgeServerPlayerDisconnectEvent.handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public NetworkConnectionInfo getNetworkConnectionInfo() {
        return this.networkConnectionInfo;
    }

    public NetworkPlayerServerInfo getNetworkPlayerServerInfo() {
        return this.networkPlayerServerInfo;
    }
}