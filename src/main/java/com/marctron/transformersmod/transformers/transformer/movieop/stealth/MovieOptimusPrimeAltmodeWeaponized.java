package com.marctron.transformersmod.transformers.transformer.movieop.stealth;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;
//import net.java.games.input.Mouse;
import org.lwjgl.input.Mouse;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.entity.EntityLargeRocket;
import com.marctron.transformersmod.network.packets.PacketShootRocket;
import com.marctron.transformersmod.network.packets.movieop.PacketMovieOptimusPrime;
import com.marctron.transformersmod.network.packets.movieop.PacketMovieOptimusPrimeStealth;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.resize.attributes.Attributes;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;


import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MovieOptimusPrimeAltmodeWeaponized extends ItemArmorTransformer {
	

	private long lastPress = 0;
	private long cooldownTime = 100; // 2000 milliseconds	
	private long time;
	
	private long lastPressShoot = 0;
	private long cooldownTimeShoot = 1500; // 2000 milliseconds	
	private long timeShoot;



public MovieOptimusPrimeAltmodeWeaponized(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		
		setRegistryName(name);
		setCreativeTab(null);
		setMaxStackSize(1);
		
	}

	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("MOVIE")));
	}
	
	public void cooldown(EntityPlayer player) {
	    long time = System.currentTimeMillis();
	    if (time > lastPress + cooldownTime) {
	    	
	    	lastPress = time;
	    } 
	} 
	
	@Override
//	@SubscribeEvent
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
//		player.getCollisionBorderSize();
		player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 1F, player.getEntityBoundingBox().minZ + 0.6F));
		player.getEntityBoundingBox().shrink(4);
		if(world.isRemote){
//		player.getCollisionBox(player).shrink(1);
		}
		player.cameraYaw=0;
		player.cameraPitch=0;
//		player.stepHeight=3;
		player.eyeHeight=0.6F;
		
//		player.capabilities.allowEdit =false;
		
		player.height= 0.8F;
		player.width= 0.6F;
		
		long timeShoot = System.currentTimeMillis();	
		if (timeShoot > lastPressShoot + cooldownTimeShoot) 
		{
		if (Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown())
			
		{
			lastPressShoot = timeShoot;
					System.out.println("it works?");
						TFNetworkManager.networkWrapper.sendToServer(new PacketShootRocket());
//						player.playSound(SoundsHandler.WFCPRIMEVEHICLE, 0.8F, 1.0F);	
//						System.out.println("ouch");
//					
//					
					}	
//				
//		
		}
	
//		if (Minecraft.getMinecraft().gameSettings.keyBindForward.isPressed()){
//			System.out.println("it works?");
//		}
		
		if (Minecraft.getMinecraft().gameSettings.keyBindAttack.isPressed()){
			System.out.println("it works?");
		}
		
		
		
		

			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	if (player.inventory.getCurrentItem().isEmpty())
	{
		
	
		if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown()){
		
		
			TFNetworkManager.networkWrapper.sendToServer(new PacketMovieOptimusPrimeStealth());
//		System.out.println("pls");
		
		
		}
	}
		 
						
				
				

			
			
				if (world.isRemote) 
				{
					

					
				

//			        if (player instanceof AbstractClientPlayer) {
			        
//			            EntityPlayer player = (EntityPlayer) entity;
					
					 
					
				
					if (ClientProxy.ROBOT_MODE.isKeyDown()) {
//						player.playSound(SoundsHandler.WFCPRIMEVEHICLE, 1F, 1.0F);	
						
						{
							TFNetworkManager.networkWrapper.sendToServer(new PacketMovieOptimusPrime());
							long time = System.currentTimeMillis();	
							if (time > lastPress + cooldownTime) {
								
									player.playSound(SoundsHandler.WFCPRIMEVEHICLE, 0.8F, 1.0F);	
//									System.out.println("ouch");
						    	lastPress = time;
						    } 
						}

						
						
								
								

								
							
								
//								if (world.isRemote)
//								{
//									if ((player instanceof EntityPlayer )) {
////										player.world.getPlayerEntityByName(getUnlocalizedName());
//									
//									if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS) { 
////										((EntityPlayerMP)this.player).connection.sendPacket(new SPacketSetSlot(-2, i, this.getStackInSlot(i)));
////										(EntityPlayerMP.connection.sendPacket(new SPacketCollectItem());
//									
//									player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS));
//
////										player.inventory.setInventorySlotContents(36, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS));
//										
//									player.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
//									player.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
//									player.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
//									player.playSound(SoundsHandler.WFCPRIMEVEHICLE, 1F, 1.0F);	
//									player.inventory.markDirty();
//									player.inventoryContainer.detectAndSendChanges();
//									player.inventoryContainer.sendContainerToPlayer()
							
									
//									player.inventoryContainer.inventorySlots.notifyAll();
									
											
										}
									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS) {
//										
//									player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS));
//										
//									}
//									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE) {
//										
//									player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE));
//										
//									}
//									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET) {
//										
//									player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET));
//									}
									
									
									
											
								
								}
								
						
						
						
						
								}
			
//					}
						
//					}
//				}
//			} 
			
			
			
			
		
	
	
	
	


	

	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
				
					
			
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.isSneak = _default.isSneak;
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.isRiding = _default.isRiding;
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.isChild = _default.isChild;
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.rightArmPose = _default.rightArmPose;
					ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized.leftArmPose = _default.leftArmPose;

					return ArmorTypes.modelMovieOptimusPrimeAltmodeWeaponized;
				}
			}
			
			return null;
		}
	}
	
	


	



