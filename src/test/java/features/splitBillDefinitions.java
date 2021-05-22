package features;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class splitBillDefinitions {

    Double bill;
    int friends;
    Double due;
    Double organisersAmountDue;
    Boolean isOwnAmountDifferent = false;

    @Given("Danny has paid a bill of {double}")
    public void dannyHasPaidABillOfBillAmount(double billAmount) {
        bill = billAmount;
    }

    @And("Danny selects to split bill with {int} friends")
    public void dannySelectsToSplitBillWithNumberPeopleFriends(int numberFriends) {
        friends = numberFriends;
    }

    @When("Danny splits bill")
    public void dannySplitsBill() {
        if(isOwnAmountDifferent)
        {
            due = (bill-organisersAmountDue) /friends ;
        }
        else {
            due = bill / (friends + 1);
        }
    }

    @Then("Individual Amount is {double}")
    public void individualAmountIsAmountDue(double amountDue) {
        double expectedResult = amountDue;
        //Act
        double actualResult = due;
        //Assert
        Assert.assertEquals(expectedResult, actualResult,0);
        System.out.println("The Amount Due Each : " + actualResult);
    }

    @And("Danny sets his amount to {double}")
    public void dannySetsHisAmountTo(double ownAmount) {
        organisersAmountDue = ownAmount;
        isOwnAmountDifferent =true;
    }
}
