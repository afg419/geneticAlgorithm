abstract class GeneticAlgorithm {
	private final float sufficientFitness;
	private final int totalBreedings;
	private final Klass classType;

	GeneticResult train(List<Chromsome> chromosomes){
		GeneticResult bestFit = maxFitness(chromsomes);
		for(int i = 0; i < totalBreedings; i++){
			if(bestFit < sufficientFitness){ break ;}
			chromosomes = breedNewGeneration(chromosomes);
			bestFit = maxFitness(chromsomes);
		}
		return bestFit;
	}

	List<List<classType>> breedNewGeneration(List<List<classType>> chromosomes){
		List<List<classType> selected = selection(chromosomes);

		List<List<classType> crossedOver = Lists.newArraylist();
		for(int i = 0; i < selected.length/2 + 1, i++){
			List<classType>[] bred = crossover(selected.get(i), selected.get(i+1));
			crossedOver.add(bred[0]);
			crossedOver.add(bred[1]);
		}

		return crossedOver.stream().map(x -> {
			mutation(chromosome);
		})
	}

	GeneticResult maxFitness(List<List<classType>> chromosomes){
		List<classType> bestFit = chromosomes.stream().maxBy(x -> fitness(x));
		return new GeneticResult(bestFit, fitness(bestFit));
	}

	private int fitness(List<classType> chromosome){}
	private List<List<classType>> selection(List<List<classType>> chromosomes){}
	private List<classType>[] crossover(List<classType> parentA, List<classType> parentB){}
	private List<classType> mutation(List<classType> chromosome){}

	public class GeneticResult {
		List<classType> result;
		int fitness;
	}
}
