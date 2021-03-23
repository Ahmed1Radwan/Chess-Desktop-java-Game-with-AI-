package controller;

public class AI_ProgressThread implements Runnable{
	Controller controller;
	AI ai;
	public AI_ProgressThread(Controller controllerIn){
		controller = controllerIn;
		ai = controller.getAI();
	}
	@Override
	public void run() {
		
		while (true){
		String text;
		if (ai.isThinking()){
			text = "Quiet Intrigue is thinking..." + ai.getBranchCounter() + "/" + ai.getNumBranches() + " moves considered.";
		}
		else{
			double score = ai.evaluate(controller.isWhiteTurn(), controller.gameTreeController.root, false);
			text = "It is your turn to move. Evaluation of current position: " + score;
		}
		
		controller.getView().updateMessageLabel(text);
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}

}
