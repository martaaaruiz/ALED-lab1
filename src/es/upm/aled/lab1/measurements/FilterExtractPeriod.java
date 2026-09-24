package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified period from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractPeriod implements Filter {
	private int min; //veo que en el cosntructor aparecen dos parametros po rlo tanto sera necesario esos parametros declararlos como atributo si no no podre acceder a ellos
	private int max;
	/**
	 * Builds the Filter from the [min, max] range defining the period that needs to
	 * be extracted. min and max are the indexes of the first and last measurements
	 * of the array obtained by calling the getMeasurements() method of EEGModel,
	 * and represent the starting and ending point of the period to be extracted.
	 * Both indexes are included and max-min must be less than the length of the
	 * Measurements array of the EGG Model.
	 * 
	 * @param min Start of the period to be extracted.
	 * @param max End of the period to be extracted.
	 */
	public FilterExtractPeriod(int min, int max) {
		// TODO
		this.min=min;
		this.max=max;
		
		
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		// TODO
		Measurement[] measurements = eeg.getMeasurements();
		if(max<measurements.length && min<measurements.length) { //compruebo que estan bien las dimensiones
			Measurement [] filteredMeasurements = new Measurement[max-min+1]; //me creo un array vacio 
			
			int k = 0; //quiero copiar por ej la posicion 9 del array eeg en la posicion 0 
			for(int i =min;i<=max;i++)
				filteredMeasurements[k++] = measurements[i];
			return new EEGModel(filteredMeasurements);
		}
		
		return new EEGModel(); //devuelvo un array vacio si los limites se salen 
	}
}
