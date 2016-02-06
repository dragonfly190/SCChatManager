package me.speedy.coding;

import java.util.HashMap;
import java.util.Map;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

@SuppressWarnings("deprecation")
public class Primal extends JavaPlugin implements Listener {

	public static Primal plugin;
	public int COOLDOWN_TIME = 3;


	HashMap<String, Integer> EnderP = new HashMap<String, Integer>();
	public static Permission perms = null;
	public static boolean globalmute = false;
	public static String Prefix = ChatColor.YELLOW + "[SCChatManager] ";
	public static boolean blockbreak = false;
	public void onEnable() {
		setupPermissions();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	public void onDisbale() {

	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	static int task;

	public static void setCooldownLength(Player player, int time,
			HashMap<String, Integer> hashmap) {
		hashmap.put(player.getName(), time);
	}

	public static int getTimeLeft(Player player, HashMap<String, Integer> hashmap) {
		int time = hashmap.get(player.getName());
		return time;
	}

	public static void startCooldown(final Player player,
			final HashMap<String, Integer> hashmap) {
		task = Bukkit.getServer().getScheduler()
				.scheduleSyncRepeatingTask(plugin, new BukkitRunnable() {
					public void run() {
						int time = hashmap.get(player.getName());
						if (time != 0) {
							hashmap.put(player.getName(), time - 1);
						} else {
							hashmap.remove(player.getName());
							Bukkit.getServer().getScheduler().cancelTask(task);
						}
					}
				}, 0L, 20L);
	}




	@EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
	public void OnChat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		if(!(player.hasPermission("core.chatmute")) && globalmute == true){
			player.sendMessage(Prefix + ChatColor.RED + "Global Chat is currently disabled!");
			event.setCancelled(true);
		}else {
			event.setCancelled(false);
		}
	}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		private final Map<String, Long> times = new HashMap();


		@EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
		public void onPlayerChat(PlayerChatEvent event) {
			if (event.getPlayer().hasPermission("core.chatslow")) {
				return;
			}

			long now = System.currentTimeMillis();
			String name = event.getPlayer().getName();
			Long lastChat = (Long)this.times.get(event.getPlayer().getName());

			if (lastChat != null)
			{
				long earliestNext = lastChat.longValue() + getConfig().getInt("interval") * 1000;
				if (now < earliestNext) {
					int timeRemaining = (int)((earliestNext - now) / 1000L) + 1;
					event.getPlayer().sendMessage(Prefix + ChatColor.RED + " You can not talk for " + timeRemaining + " more second" + (timeRemaining > 1 ? "s" : ""));
					event.setCancelled(true);
					return;
				}
			}
			this.times.put(name, Long.valueOf(now));
		}

		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("chatclear") || (cmd.getName().equalsIgnoreCase("cc"))) {
				if(Primal.perms.playerHas(p, "Core.ChatClear")) {
					if (!(sender instanceof Player)) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix + "&4ERROR: &C You must be a player to execute this command!"));
						return true;
					}
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" "); 
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Prefix + "The chat has been cleared by" + "&6 " + p.getName()));

				}else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix + "You dont have permission to use this command!"));
				}
				return false;
			}
			if(cmd.getName().equalsIgnoreCase("chatmute") || (cmd.getName().equalsIgnoreCase("cm"))) {
				if(Primal.perms.playerHas(p, "core.chatmute")) {
					if (!(sender instanceof Player)) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix + "&4ERROR: &c You must be a player to execute this command!"));
						return true;
					}
				}else {
					p.sendMessage(Prefix + ChatColor.RED + "You dont have permission to use this command!");
					return false;
				}
				if(globalmute == false) {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Prefix + "&9The Global chat has been muted by" + ChatColor.GOLD + " "+ p.getName()));
					globalmute = true;
				}else if(globalmute == true) {
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Prefix + "&aThe Global chat has been enabled!"));
					globalmute = false;
				}
			}
			if(cmd.getName().equalsIgnoreCase("chatslow") || (cmd.getName().equalsIgnoreCase("cs"))) {
				if (!sender.hasPermission("core.chatslow")) {
					sender.sendMessage(Prefix + ChatColor.RED + "You dont have permission to use this command!");
					return true;
				}

				if (args.length != 1) {
					sender.sendMessage(Prefix + ChatColor.GOLD + "Delay for each Chat Message: " + ChatColor.GREEN + String.valueOf(getConfig().getInt("interval")) + " seconds");
					return true;
				}
				try
				{
					int interval = Integer.parseInt(args[0]);
					getConfig().set("interval", Integer.valueOf(interval));
					saveConfig();
					sender.sendMessage(Prefix + ChatColor.GREEN + "Updated time between messages to " + ChatColor.GOLD + args[0] + ChatColor.GREEN + " second" + (interval == 1 ? "" : "s"));
				} catch (NumberFormatException e) {
					sender.sendMessage(Prefix + ChatColor.GOLD +" " + args[0] + ChatColor.RED + " is not a valid number");
				}
			}
			return false;
		}
	}

