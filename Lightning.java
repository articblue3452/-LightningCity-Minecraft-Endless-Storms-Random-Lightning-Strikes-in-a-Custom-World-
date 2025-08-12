package server.lightning;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class Lightning extends JavaPlugin {

    private static final String LIGHTNING_WORLD = "LightningCity";
    private final Random random = new Random();

    private boolean pluginEnabled = true;
    private boolean strikeAllPlayers = false;

    @Override
    public void onEnable() {
        createLightningWorld();        // Make sure world exists
        startWeatherTask();           // Force stormy weather
        startLightningTask();         // Strike lightning
        getLogger().info("⚡ LightningCity plugin enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("⚡ LightningCity plugin disabled.");
    }

    private void createLightningWorld() {
        if (Bukkit.getWorld(LIGHTNING_WORLD) != null) return;

        getLogger().info("Creating world: " + LIGHTNING_WORLD);
        WorldCreator wc = new WorldCreator(LIGHTNING_WORLD);
        wc.environment(World.Environment.NORMAL);
        wc.type(WorldType.NORMAL);
        wc.generateStructures(true);
        wc.createWorld();
    }

    private void startWeatherTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                World world = Bukkit.getWorld(LIGHTNING_WORLD);
                if (world != null) {
                    world.setStorm(true);
                    world.setThundering(true);
                    world.setWeatherDuration(Integer.MAX_VALUE);
                }
            }
        }.runTaskTimer(this, 0L, 20L * 60); // Every 60 seconds
    }

    private void startLightningTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!pluginEnabled) return;

                World world = Bukkit.getWorld(LIGHTNING_WORLD);
                if (world == null) return;

                List<Player> players = world.getPlayers();
                if (!players.isEmpty()) {
                    if (strikeAllPlayers) {
                        for (Player player : players) {
                            world.strikeLightning(player.getLocation());
                        }
                    } else {
                        Player randomPlayer = players.get(random.nextInt(players.size()));
                        world.strikeLightning(randomPlayer.getLocation());
                    }
                }

                // Random location strike
                int x = random.nextInt(201) - 100;
                int z = random.nextInt(201) - 100;
                int y = world.getHighestBlockYAt(x, z);
                if (y <= 0) y = world.getSpawnLocation().getBlockY();
                Location loc = new Location(world, x + 0.5, y, z + 0.5);
                world.strikeLightning(loc);
            }
        }.runTaskTimer(this, 0L, 100L); // Every 5 seconds
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("lightningcity"))
            return false;

        if (!sender.hasPermission("lightningcity.control")) {
            sender.sendMessage("§cYou don't have permission.");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("§eUsage: /lightningcity <on|off|mode>");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "on":
                pluginEnabled = true;
                sender.sendMessage("§aLightningCity is now active!");
                break;
            case "off":
                pluginEnabled = false;
                sender.sendMessage("§cLightningCity is now disabled!");
                break;
            case "mode":
                strikeAllPlayers = !strikeAllPlayers;
                sender.sendMessage("§bMode set to §e" + (strikeAllPlayers ? "ALL players" : "RANDOM player"));
                break;
            default:
                sender.sendMessage("§eUsage: /lightningcity <on|off|mode>");
        }
        return true;
    }
}
