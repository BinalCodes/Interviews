

	import java.io.*;
	import java.util.*;

	/*
	 * To execute Java, please define "static void main" on a class
	 * named Solution.
	 *
	 * If you need more classes, simply define them inline.
	 */

	class HavenLife {
	  public static void main(String[] args) {
	   // Agents initialization
	    Agent bob = new Agent("Bob", 0.02);
	    Agent superA = new Agent("SA" , 0.0325);
	    Agent superC = new Agent("SC", 0.0225);
	    Agent superD= new Agent("SD" , 0.275);
	    Agent superX = new Agent("SX", 0.025);
	    Agent superZ = new Agent("SZ" , 0.175);
	    
	    //Plan Initialization
	    Plan plan1 = new Plan("Plan1" , 3);
	    plan1.commPer = new double[]{0.5,0.05,0};
	  
	    
	    
	    //Hierarchy init
	    Agent[] h1Agents = new Agent[4];
	    h1Agents[0] = bob;
	    h1Agents[1] = superX;
	    h1Agents[2] = superA;
	    h1Agents[3] = superC;
	    Hierarchy H1 = new Hierarchy("H1", h1Agents);
	    
	    long faceAmt = 100000;
	    
	    // method to calc commisson
	    System.out.println(calcCommisson(faceAmt,H1,plan1));

	  }
	  public static double calcCommisson(long faceAmt,  Hierarchy H1, Plan plan1 ){
	    long totalCommisson = 0;
	    for(int i =0 ; i< plan1.numOfRules ; i++){
	      //double commisson = plan1.commPer[i] * H1.agentsList[i]* faceAmt;
	      totalCommisson += (plan1.commPer[i] * H1.agentsList[i].commisonPer* faceAmt);
	    }
	    return totalCommisson;
	  }
	}

	// - Selling Agent (Bob) gets 50% of the agent commission % of policy amount = 50% * 2% * 100000 = 1000
	// - First Super Agent (X) gets 5% of the agent commission % of the policy amount = 5% * 2.5% * 100000 = 125
	// - Second Super Agent (A) gets 0% of the agent commission % of the policy amount = 0% * 3.25% * 100000 = 0
	// - Third Super Agent (C) gets 0% of the agent commission % of the policy amount = 0% * 2.25% * 100000 = 0

	class Plan{
	  String planName;
	  int numOfRules;
	  double[] commPer;
	  Plan(String pName,int nRules){
	    this.numOfRules = nRules;
	    this.planName = pName;
	    commPer = new double[nRules];
	  }
	  
	  
	}

	class Agent{
	  String agentName;
	  double commisonPer;
	  Agent(String agentName, double commisonPer){
	    this.agentName = agentName;
	    this.commisonPer = commisonPer;
	  }
	}
	class Hierarchy{
	  String name;
	  Agent[] agentsList;
	  Hierarchy(String name , Agent[] aList){
		  this.name = name;
		  this.agentsList = aList;
	  }
	}

