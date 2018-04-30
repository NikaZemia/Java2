public class Calculator{
	private int result;
	
	public void add(int ... params){
		for(Integer param : params){
			this.result += param;
		}
	}

	public void minus(int... params){
		for (Integer param:params){
			if(this.result != 0)
				this.result -= param;
			else
				this.result = param;
		}
	}

	public void multiplay(int... params){
		for (Integer param:params){
			if(this.result != 0)
				this.result *= param;
			else
				this.result = param;
		}
	}

	public void divide(int... params){
		for (Integer param:params){
			if(this.result!= 0) {
				if (param != 0)
					this.result /= param;
				else{
					System.out.println("Can not divide by 0");
					cleanResults();
				}
			}
			else
				this.result = param;
		}
	}
	
	public int getResult(){
		return this.result;
	}
	
	public void cleanResults(){
		this.result = 0;
	}
}