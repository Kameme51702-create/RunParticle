package com.runparticle.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.particle.ParticleTypes;

public class RunParticleClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		ClientTickEvents.END_CLIENT_TICK.register(client -> {

			if (client.player == null) return;

			// 前進速度
			double speed = client.player.getVelocity().horizontalLength();

			// ダッシュ中のみ
			if (client.player.isSprinting() && speed > 0.15) {

				client.world.addParticleClient(
						ParticleTypes.END_ROD,

						client.player.getX(),
						client.player.getY() + 0.5,
						client.player.getZ(),

						0,
						0,
						0
				);
			}
		});
	}
}