/*
 * Code Lyoko Mod for Minecraft v@VERSION
 * Copyright 2013 Cortex Modders, Matthew Warren, Jacob Rhoda, and
 * other contributors.
 * Released under the MIT license
 * http://opensource.org/licenses/MIT
 */

package matt.lyoko.client.render.mobs;

import matt.lyoko.client.model.mobs.ModelBlok;
import matt.lyoko.entities.mobs.EntityXanafiedMob;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderXanafiedMob extends RendererLivingEntity
{
    private static ResourceLocation texture = new ResourceLocation("lyoko:textures/models/blok.png");

    public RenderXanafiedMob()
    {
        super(new ModelBlok(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return RenderXanafiedMob.texture;
    }

    @Override
    public void doRenderLiving(EntityLivingBase ent, double par2, double par4, double par6, float par8, float par9)
    {
        EntityXanafiedMob xana = (EntityXanafiedMob) ent;
        if (xana != null && xana.infectedMob != null)
        {
            RendererLivingEntity render = (RendererLivingEntity) RenderManager.instance.getEntityRenderObject(xana.infectedMob);
            render.doRenderLiving(xana, par2, par4, par6, par8, par9);
        } else
            super.doRenderLiving(ent, par2, par4, par6, par8, par9);
    }
}