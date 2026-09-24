package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {
	private int[] validChannels; //lo programo pq veo que esta en el constructor que es la siguiente linea 
	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	public FilterExtractChannels(int[] validChannels) {
		// TODO
		this.validChannels=validChannels;
		
		
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		// TODO
		Measurement[] measurements = eeg.getMeasurements();
		Measurement[] filteredMeasurements = new Measurement[measurements.length];
		
		for(int i=0;i<measurements.length;i++) {
			float[] channels = new float[validChannels.length];
			int k=0;
			for(int channel:validChannels) //recorro el arrayt de valid channels los numeros que quiero 
				channels[k++] = measurements[i].getChannel(channel); //copio la medida en el array nuevo 
			filteredMeasurements[i] = new Measurement(channels);
			
			
		}
		
		return new EEGModel(filteredMeasurements);
	}

}

