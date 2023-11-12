package com.naka.moon;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Moon extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        // プラグインを有効化したときの初期設定
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("起動しました");

    }

    @Override
    public void onDisable() {
        // プラグインが無効になったときの後始末
    }

    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        String worldName = player.getWorld().getName();

        // カスタムワールド名を確認し、"moonworld"の場合に無重力を設定
        if (worldName.equals("moon")) {

            // プレイヤーに無重力を設定
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage("ようこそ Moonworld へ！無重力モードが有効になりました。");
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 13, true, false));





        } else {
            // 他のワールドに移動した場合、無重力モードを解除
            player.setAllowFlight(false);
            player.setFlying(false);
            player.removePotionEffect(PotionEffectType.JUMP);


            player.removePotionEffect(PotionEffectType.LEVITATION);
        }
    }
}



