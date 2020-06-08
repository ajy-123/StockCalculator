package sample;

public class Algorithms extends Main {
    double totalAssets;
    double currentAssets;
    double totalLiabilities;
    double shareholdersEquity;
    double sharesOutstanding;
    double preferredStock;
    double marketPrice;
    double currentLiabilities;
    double netEarnings;

    public Algorithms(double asset, double  currentasset, double liability, double currentliablity,
                      double equity, double outstanding, double preferred, double market, double earnings){
        this.totalAssets = asset;
        this.currentAssets = currentasset;
        this.totalLiabilities = liability;
        this.currentLiabilities = currentliablity;
        this.shareholdersEquity = equity;
        this.sharesOutstanding = outstanding;
        this.preferredStock = preferred;
        this.marketPrice = market;
        this.netEarnings = earnings;
    }

    public double NetCurrentAssetValue(){
        double NCAVPS = (currentAssets - (totalLiabilities + preferredStock))/sharesOutstanding;
        return NCAVPS;


    }

    public double PriceToEarnings(){

        double pricePerShare = marketPrice/sharesOutstanding;
        double earningsPerShare = netEarnings/sharesOutstanding;
        double PriceToEarnings = pricePerShare/earningsPerShare;
        return PriceToEarnings;

    }

    public double BookValuePerShare(){
        double BookValuePerShare = (shareholdersEquity - preferredStock)/sharesOutstanding;
        return BookValuePerShare;
    }

    public double PriceToBook (){
        double PriceToBook = marketPrice/ BookValuePerShare();
        return PriceToBook;
    }

    public double CurrentAssetsToLiabilities(){
        double currentAssetsToLiabilities = currentAssets / currentLiabilities;
        return currentAssetsToLiabilities;
    }

    public double[] RatiosList(){
        double[] ratiosList = {NetCurrentAssetValue(), PriceToEarnings(),BookValuePerShare(), PriceToBook(),
        CurrentAssetsToLiabilities()};
        return ratiosList;
    }
}