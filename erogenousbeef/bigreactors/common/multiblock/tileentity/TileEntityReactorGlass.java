package erogenousbeef.bigreactors.common.multiblock.tileentity;

import erogenousbeef.bigreactors.api.HeatPulse;
import erogenousbeef.bigreactors.api.IHeatEntity;
import erogenousbeef.bigreactors.api.IRadiationModerator;
import erogenousbeef.bigreactors.api.IRadiationPulse;
import erogenousbeef.bigreactors.common.multiblock.MultiblockReactor;
import erogenousbeef.core.multiblock.MultiblockControllerBase;
import erogenousbeef.core.multiblock.MultiblockTileEntityBase;
import erogenousbeef.core.multiblock.MultiblockValidationException;
import erogenousbeef.core.multiblock.rectangular.RectangularMultiblockTileEntityBase;

public class TileEntityReactorGlass extends TileEntityReactorPartBase {

	@Override
	public void isGoodForFrame()  throws MultiblockValidationException {
		throw new MultiblockValidationException(String.format("%d, %d, %d - Reactor glass may only be used on the exterior faces, not as part of a reactor's frame or interior", xCoord, yCoord, zCoord));
	}

	@Override
	public void isGoodForSides() throws MultiblockValidationException {
	}

	@Override
	public void isGoodForTop() throws MultiblockValidationException {
	}

	@Override
	public void isGoodForBottom() throws MultiblockValidationException {
	}

	@Override
	public void isGoodForInterior() throws MultiblockValidationException {
		throw new MultiblockValidationException(String.format("%d, %d, %d - Reactor glass may only be used on the exterior faces, not as part of a reactor's frame or interior", xCoord, yCoord, zCoord));
	}

	@Override
	public void receiveRadiationPulse(IRadiationPulse radiation) {
		// TODO FIXME
		float freePower = radiation.getSlowRadiation() * 0.25f;
		
		// Convert 25% of incident radiation to power, for balance reasons.
		radiation.addPower(freePower);
		
		// Slow radiation is all lost now
		radiation.setSlowRadiation(0);
		
		// And zero out the TTL so evaluation force-stops
		radiation.setTimeToLive(0);
	}

	@Override
	public void onMachineActivated() {
	}

	@Override
	public void onMachineDeactivated() {
	}
}