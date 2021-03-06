@uitest
Feature: Advanced Filter Overlay button(Add, Search, AND, OR, NOT, DEL, BREAK) display

Background: 
	Given I am on advanced filter overlay 
@smoke
Scenario: Verify button display in advanced filter overlay using single filter values 
	Given I added 1 filter value to advanced filter overlay 	
	Then I should see filter value added in filter overlay 
	And I should verify following buttons displayed as below 
		|Button  |Enabled  | 
		|AND     |false    |
		|OR      |false    |
		|NOT     |true     | 
		|DEL     |true     | 		
		|BREAK   |false    |
		|Add     |true     | 		
		|Search  |true     |
@smoke
Scenario: Verify button display in advanced filter overlay using multiple filter values 
	Given I added 2 filter values to advanced filter overlay 	
	Then I should see filter values added in filter overlay 
	And I should verify following buttons displayed as below
		|Button  |Enabled  | 
		|AND     |true     |
		|OR      |true     |
		|NOT     |true     | 
		|DEL     |true     | 		
		|BREAK   |false    |
		|Add     |true     | 		
		|Search  |false    |

#new scenario	
Scenario Outline: Verify button display in advanced filter overlay while de-selecting all filter value/s 
	Given I added <Count> filter value/s to advanced filter overlay	
	Then I should see filter value/s added in filter overlay 
	And I should verify all filter value checkboxes as selected 
	When I uncheck filter value/s 
	And I should verify following buttons displayed as below 
		|Button  |Enabled| 
		|AND     |false  | 	
		|OR      |false  | 	
		|NOT     |false  | 	 
		|DEL     |false  | 		
		|BREAK   |false  |
		|Add     |true   | 		
		|Search  |false  |	
	Examples: 
		|Count  | 		
		|1      | 		
		|2      |
		
Scenario Outline: Verify button display while selecting condition buttons(AND, OR, AND NOT, OR NOT) 
	Given I added 2 filter values to advanced filter overlay 
	When I select condition button/s '<button>' 
	Then I should verify following buttons displayed as below
		|Button  |Enabled | 
		|AND     |false   |
		|OR      |false   |
		|NOT     |true    | 
		|DEL     |true    | 		
		|BREAK   |true    |		
		|Add     |true    | 		
		|Search  |true    |
	Examples: 
		|button  | 	
		|OR      | 
		|AND     |		
		|OR, NOT | 
		|AND, NOT| 		

#new scenario
Scenario: Verify button display while selecting condition button NOT 
	Given I added 2 filter values to advanced filter overlay 
	When I select condition button 'NOT' 
	Then I should verify following buttons displayed as below
		|Button  |Enabled| 
		|AND     |true   |
		|OR      |true   |
		|NOT     |true   | 
		|DEL     |true   | 		
		|BREAK   |false  |
		|Add     |true   | 		
		|Search  |false  |	

#new scenario
Scenario Outline: Verify the button display while deleting filter value/s from filter table 
	Given I added <Count> filter value/s to advanced filter overlay  
	Then I should see filter value/s added in filter overlay 
	When I select condition button 'DEL'
	Then I should see filter value/s removed from filter overlay 
	And I should verify following buttons displayed as below
	    |Button  |Enabled|
	    |Add     |true   |
		|AND     |false  |
		|OR      |false  |
		|NOT     |false  | 
		|DEL     |false  | 		
		|BREAK   |false  | 
		|Search  |false  |
	Examples: 
		|Count | 	
		|1     | 
		|2     |