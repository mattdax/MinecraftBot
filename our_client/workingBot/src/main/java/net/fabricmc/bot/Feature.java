package net.fabricmc.bot;

import java.util.List;
import java.util.StringJoiner;

import net.fabricmc.event.EventManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Style;




public abstract class Feature {
	protected static final botClient client = botClient.INSTANCE;
	protected static final EventManager EVENTS = client.getManager();
	protected static final MinecraftClient MC = botClient.MC;

	
	public abstract String getName();
	
	public abstract String getDescription();	
	
	public String getWrappedDescription(int width)
	{
		List<StringVisitable> lines = MC.textRenderer.getTextHandler()
			.wrapLines(getDescription(), width, Style.EMPTY);
		
		StringJoiner joiner = new StringJoiner("\n");
		lines.stream().map(StringVisitable::getString)
			.forEach(s -> joiner.add(s));
		
		return joiner.toString();
	}

	
	public abstract String getPrimaryAction();
	
	public void doPrimaryAction()
	{
		
	}
	
	public boolean isEnabled()
	{
		return false;
	}

}
