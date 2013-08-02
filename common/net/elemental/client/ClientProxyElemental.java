package net.elemental.client;

import net.elemental.client.render.RenderHandlers;
import net.elemental.common.CommonProxyElemental;

public class ClientProxyElemental extends CommonProxyElemental
{
	public void registerRenderers()
	{
		RenderHandlers.initRenderers();
	}
}
