package com.marginallyclever.robotOverlord.dhRobot;

import com.jogamp.opengl.GL2;
import com.marginallyclever.robotOverlord.modelInWorld.ModelInWorld;
import com.marginallyclever.robotOverlord.physicalObject.PhysicalObject;

/**
 * DHTool is a model that has a DHLink equivalence.
 * In this way it can perform transforms and have sub-links.
 * @author Dan Royer
 *
 */
public class DHTool extends ModelInWorld {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DHLink dhlinkEquivalent;
	PhysicalObject subjectBeingHeld;
	
	@Override
	public void render(GL2 gl2) {
		super.render(gl2);
		dhlinkEquivalent.renderPose(gl2);
	}
}
