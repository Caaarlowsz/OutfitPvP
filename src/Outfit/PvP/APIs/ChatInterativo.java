package Outfit.PvP.APIs;

import net.minecraft.server.v1_7_R4.ChatClickable;
import net.minecraft.server.v1_7_R4.ChatHoverable;
import net.minecraft.server.v1_7_R4.ChatMessage;
import net.minecraft.server.v1_7_R4.ChatModifier;
import net.minecraft.server.v1_7_R4.EnumClickAction;
import net.minecraft.server.v1_7_R4.EnumHoverAction;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.MinecraftServer;
import net.minecraft.server.v1_7_R4.PlayerList;

public class ChatInterativo {
	public static void Comando(String p, String MensagemNoChat, String ComandoAoClicar, String MouseEncima) {
		IChatBaseComponent base = new ChatMessage(MensagemNoChat);
		base.setChatModifier(new ChatModifier());
		base.getChatModifier().setChatClickable(new ChatClickable(EnumClickAction.RUN_COMMAND, ComandoAoClicar));
		base.getChatModifier()
				.a(new ChatHoverable(EnumHoverAction.SHOW_TEXT, new ChatMessage(MouseEncima)));
		PlayerList list = MinecraftServer.getServer().getPlayerList();
		list.getPlayer(p).sendMessage(base);
	}

	public static void Link(String p, String Mensagem, String LinkAoClicar, String MouseEncima) {
		IChatBaseComponent base = new ChatMessage(Mensagem);
		base.setChatModifier(new ChatModifier());
		base.getChatModifier().setChatClickable(new ChatClickable(EnumClickAction.OPEN_URL, LinkAoClicar));
		base.getChatModifier()
				.a(new ChatHoverable(EnumHoverAction.SHOW_TEXT, new ChatMessage(MouseEncima)));
		PlayerList list = MinecraftServer.getServer().getPlayerList();
		list.getPlayer(p).sendMessage(base);
	}
}
