package WindowBuilder.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.HashMap;

public class Layer {
// Attributes
	public String name;
	public String filePath;
	public int nRows;
	public int nCols;
	public double[] origin = new double[2];
	public double resolution;
	public double[] values;
	public double nullValue;

	// Methods
	// init method
	@SuppressWarnings("unused")
	public Layer(String layerName, String filePath) {

		this.name = layerName;
		this.filePath = filePath;

		// Read the file		
		try {
			// Input file 
			File pathFile = new File(filePath);
			FileReader readerFile = new FileReader(pathFile);
			BufferedReader bReader = new BufferedReader(readerFile);

			// Read each line of Strings
			String text;
			text = bReader.readLine();
			int nCols = Integer.parseInt(text.substring(5).trim());
			this.nCols = nCols;

			text = bReader.readLine();
			int nRows = Integer.parseInt(text.substring(5).trim());
			this.nRows = nRows;

			text = bReader.readLine();
			double origin0 = Double.parseDouble(text.substring(10).trim());
			this.origin[0] = origin0;

			text = bReader.readLine();
			double origin1 = Double.parseDouble(text.substring(10).trim());
			this.origin[1] = origin1;

			text = bReader.readLine();
			double resolution = Double.parseDouble(text.substring(9).trim());
			this.resolution = resolution;

			text = bReader.readLine();
			double nullValue = Double.parseDouble(text.substring(13).trim());
			this.nullValue = nullValue;

			text = bReader.readLine();
			int count = 1;
			int index = -1;
			double[] values = new double[nRows*nCols];
			while (text != null) {
				String[] value = text.split(" ");
				int valuesLength = value.length;
				for (int i=0; i<valuesLength; i++) {
					index++;
					values[index] = Double.parseDouble(value[i]);
				}
				text = bReader.readLine();
				count++;
			}
			this.values = values;
			bReader.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Ex03 
	public Layer(String outlayerName, int nCols, int nRows, double[] origin, double resolution, double nullValue) {

		this.name = outlayerName;
		this.nRows = nRows;
		this.nCols = nCols;
		this.origin = origin;
		this.resolution = resolution;
		this.nullValue = nullValue;
		this.values = new double[nRows*nCols];
	}

	// Print the Layer
	public void print() {
		System.out.println("ncols          " + nCols);
		System.out.println("nrows          " + nRows);
		System.out.println("xllcorner      " + origin[0]);
		System.out.println("yllcorner      " + origin[1]);
		System.out.println("cellsize       " + resolution);
		System.out.println("NODATA_value   " + nullValue);

		for (int i=0; i<nRows; i++) {
			for (int j=0; j<nCols; j++) {
				System.out.print(values[i*nCols+j]+ " ");
			}
			System.out.println();
		}
	}

	// creates and saves a new layer
	public void save(String outputFileName) {
		// save it as an ASCII file

		try {
			File file = new File(outputFileName);
			FileWriter fWriter = new FileWriter(file);
			// saving
			fWriter.write("ncols         " + nCols + "\n");
			fWriter.write("nrows         " + nRows + "\n");
			fWriter.write("xllcorner     " + origin[0] + "\n");
			fWriter.write("yllcorner     " + origin[1] + "\n");
			fWriter.write("cellsize      " + resolution + "\n");
			fWriter.write("NODATA_value  " + nullValue + "\n");

			for (int x=0; x<nRows; x++) {
				for (int y=0; y<nCols; y++) {
					fWriter.write(values[x*nCols+y]+ " ");
				}
				fWriter.write("\n");
			}
			fWriter.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Create a BufferedImage of the layer in grayscale
	public BufferedImage toImage() {
		BufferedImage image = new BufferedImage(nCols, nRows, BufferedImage.TYPE_INT_RGB);
		WritableRaster raster = image.getRaster();
		int color[] = new int[3];

		double minimum = useGetMinIndirectly();
		double maximum = useGetMaxIndirectly();

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				color[0] = (int)(255*(1 - (values[i*nCols + j] - minimum)/(maximum - minimum)));
				color[1] = (int)(255*(1 - (values[i*nCols + j] - minimum)/(maximum - minimum)));
				color[2] = (int)(255*(1 - (values[i*nCols + j] - minimum)/(maximum - minimum)));
				raster.setPixel(j, i, color);
			}	
		}
		return image;
	}

	// Visualize a BufferedImage of the layer in color 
	public BufferedImage toImage(double[] colorsType) {
		BufferedImage image = new BufferedImage(nRows, nCols, BufferedImage.TYPE_INT_RGB);
		WritableRaster raster = image.getRaster();
		int[] blackColor = new int[3];
		blackColor[0] = 0;
		blackColor[1] = 0;
		blackColor[2] = 0;

		double colors[][] = new double[colorsType.length][3];
		for (int i = 0; i < colorsType.length; i++) {
			colors[i][0] = Math.random() * 256;
			colors[i][1] = Math.random() * 256;
			colors[i][2] = Math.random() * 256;
		}
		for (int j = 0; j < nRows; j++) {
			for (int k = 0; k < nCols; k++) {
				raster.setPixel(k, j, blackColor);
				for (int l = 0; l < colorsType.length; l++) {
					if (values[j*nCols + k] == colorsType[l]) {
						raster.setPixel(k, j, colors[l]);
					}
				}
			}
		}
		return image;
	}

	// public and private methods 
	public double useGetMaxIndirectly() {
		double max = this.getMax();
		return max;
	}
	public double useGetMinIndirectly() {
		double min = this.getMin();
		return min;
	}

	private double getMax() {
		double max = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (values[i*nCols + j] > max) {
					max = values[i*nCols + j];
				}
			}	
		}
		return max;
	}

	private double getMin() {
		double min = Double.POSITIVE_INFINITY;
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (values[i*nCols + j] < min) {
					min = values[i*nCols + j];
				}
			}	
		}
		return min;
	}

	// Ex03
	public Layer localSum(Layer inLayer, String outLayerName) {
		Layer outLayer = new Layer(outLayerName, nRows, nCols, origin, resolution, nullValue);
		for (int i=0; i<(nRows*nCols); i++) {
			outLayer.values[i] = values[i] + inLayer.values[i];	
		}
		return outLayer;
	}

	// check for edge cases
	private boolean inBounds(int row, int column) {
		boolean isInside = true;
		if (row < 0 || row > nRows || column < 0 || column > nCols) {isInside = false;}
		return isInside;
	}
	public Layer focalVariety(int radiusNeighborhood, boolean isSquare, String outputLayerName) {

		Layer outLayer  = new Layer(outputLayerName, nRows, nCols, origin, resolution, nullValue);
		ArrayList<Double> checkList = new ArrayList<>(); 

		if (isSquare) {
			for (int i=0; i<(nRows*nCols); i++) {
				Integer[] surroundings = getNeighborhood(i, radiusNeighborhood, isSquare);
				for (int j = 0; j < surroundings.length; j++) {
					Double value = new Double(values[surroundings[j]]);
					if (!checkList.contains(value)) {
						checkList.add(values[surroundings[j]]);
					}
				}
				double newValue = checkList.size();
				outLayer.values[i] = newValue;
			}
		}
		else {
			for (int i=0; i<(nRows*nCols); i++) {
				Integer[] surroundings = getNeighborhood(i, radiusNeighborhood, isSquare);
				for (int j = 0; j < surroundings.length; j++) {
					Double value = new Double(values[surroundings[j]]);
					if (!checkList.contains(value)) {
						checkList.add(values[surroundings[j]]);
					}
				}
				double newValue = checkList.size();
				outLayer.values[i] = newValue;
			}
		}
		return outLayer;
	}

	public Layer zonalMinimum(Layer zoneLayer, String outLayerName) {
		Layer outLayer = new Layer(outLayerName, nRows, nCols, origin, resolution, nullValue);

		HashMap<Double, Double> hm = new HashMap<Double, Double>();

		for (int i = 0; i < (nRows * nCols); i++) {
			if (hm.containsKey(zoneLayer.values[i])) {
				if (values[i] < hm.get(zoneLayer.values[i]) && values[i]!= nullValue) {
					hm.replace(zoneLayer.values[i], values[i]);
				}
			} else {
				if (values[i] != nullValue) {
					hm.put(zoneLayer.values[i], values[i]);
				}
			}
		}
		for (int i = 0; i < (nRows * nCols); i++) {
			outLayer.values[i] = hm.get(zoneLayer.values[i]);
		}
		return outLayer;
	}

	private Integer[] getNeighborhood(int index, int radius, boolean isSquare) {

		int row  = index/this.nCols;
		int column = index%this.nCols;
		ArrayList<Integer> indices = new ArrayList<>();

		if (isSquare) {
			for (int i = (row-radius); i <= (row+radius) ; i++){
				for (int j = (column-radius); j <= (column+radius); j++) {
					if (inBounds(i/nCols, i%nCols) /*&& i != index*/) {
						Integer values= new Integer(i*(row+radius) + j);
						indices.add(values);
					}
				}
			}
		}
		else {
			// only search for circle shape locations
			int jStart = column - radius;
			int jEnd = column - radius;
			for (int i = (row-radius); i <= (row+radius); i++) {
				for (int j = jStart; j <= jEnd; j++) {
					if (inBounds(i, j) /*&& i*j != index*/) {
						Integer values= new Integer(i*(row+radius)+ j);
						indices.add(values);
					}
					if (i < row) {
						jStart--;
						jEnd++;
					}
					else {
						jStart++;
						jEnd--;
					}
				}
			}
		}
		Integer[] returnIndices = new Integer[indices.size()];
		int counter = 0;
		for (Integer intIndex: indices) {
			returnIndices[counter] = intIndex;
			counter++;
		}
		return returnIndices;
	}
}
