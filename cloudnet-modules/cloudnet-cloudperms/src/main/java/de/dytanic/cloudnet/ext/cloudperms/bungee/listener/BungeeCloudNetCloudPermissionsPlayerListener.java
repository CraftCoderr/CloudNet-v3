package de.dytanic.cloudnet.ext.cloudperms.bungee.listener;

import de.dytanic.cloudnet.driver.permission.IPermissionUser;
import de.dytanic.cloudnet.ext.cloudperms.CloudPermissionsHelper;
import de.dytanic.cloudnet.ext.cloudperms.CloudPermissionsPermissionManagement;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.PermissionCheckEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.UUID;

public final class BungeeCloudNetCloudPermissionsPlayerListener implements Listener {

    @EventHandler
    public void handle(LoginEvent event) {
        CloudPermissionsHelper.initPermissionUser(event.getConnection().getUniqueId(), event.getConnection().getName());
    }

    @EventHandler
    public void handle(PermissionCheckEvent event) {
        CommandSender sender = event.getSender();

        if (sender instanceof ProxiedPlayer) {
            UUID uniqueId = ((ProxiedPlayer) sender).getUniqueId();

            IPermissionUser permissionUser = CloudPermissionsPermissionManagement.getInstance().getUser(uniqueId);

            if (permissionUser != null) {
                event.setHasPermission(CloudPermissionsPermissionManagement.getInstance().hasPlayerPermission(permissionUser, event.getPermission()));
            }
        }
    }

    @EventHandler
    public void handle(PlayerDisconnectEvent event) {
        UUID uniqueId = event.getPlayer().getUniqueId();

        CloudPermissionsPermissionManagement.getInstance().getCachedPermissionUsers().remove(uniqueId);

    }

}