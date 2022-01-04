package net.fabricmc.events;

import java.util.ArrayList;
import java.util.Objects;

import net.fabricmc.event.Listener;
import net.fabricmc.event.cancellableEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public interface ChatOutputListener extends Listener
{

	public static final Logger LOGGER = LogManager.getLogger("mattsminecraftbot");
	public void onSentMessage(ChatOutputEvent event);
	
	public static class ChatOutputEvent
		extends cancellableEvent<ChatOutputListener>
	{
		private final String originalMessage;
		private String message;
		
		public ChatOutputEvent(String message)
		{
			this.message = Objects.requireNonNull(message);
			originalMessage = message;
		}
		
		public String getMessage()
		{
			return message;
		}
		
		public void setMessage(String message)
		{
			this.message = message;
		}
		
		public String getOriginalMessage()
		{
			return originalMessage;
		}
		
		public boolean isModified()
		{
			return !originalMessage.equals(message);
		}
		
		@Override
		public void fire(ArrayList<ChatOutputListener> listeners)
		{
			LOGGER.info("Message Sent!");
			for(ChatOutputListener listener : listeners)
			{
				
				listener.onSentMessage(this);
				
				if(isCancelled())
					break;
			}
		}
		
		@Override
		public Class<ChatOutputListener> getListenerType()
		{
			return ChatOutputListener.class;
		}
	}
}
