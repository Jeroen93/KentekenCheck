package nl.jeroen.kentekencheck.model;

import com.socrata.android.client.SodaEntity;
import com.socrata.android.client.SodaField;

@SuppressWarnings("SpellCheckingInspection")
@SodaEntity
public class RdwVehicle {

    @SodaField("kenteken")
    private String kenteken;

    @SodaField("voertuigsoort")
    private String voertuigsoort;

    @SodaField("merk")
    private String merk;

    @SodaField("handelsbenaming")
    private String handelsbenaming;

    @SodaField("vervaldatum_apk")
    private int vervaldatumApk;

    @SodaField("datum_tenaamstelling")
    private int datumTenaamstelling;

    @SodaField("bruto_bpm")
    private int brutoBpm;

    @SodaField("inrichting")
    private String inrichting;

    @SodaField("aantal_zitplaatsen")
    private int aantalZitplaatsen;

    @SodaField("eerste_kleur")
    private String eersteKleur;

    @SodaField("tweede_kleur")
    private String tweedeKleur;

    @SodaField("aantal_cilinders")
    private int aantalCilinders;

    @SodaField("cilinderinhoud")
    private int cilinderInhoud;

    @SodaField("massa_ledig_voertuig")
    private int massaLedigVoertuig;

    @SodaField("toegestane_maximum_massa_voertuig")
    private int toegestaneMaxMassaVoertuig;

    @SodaField("massa_rijklaar")
    private int massaRijklaar;

    @SodaField("maximum_massa_trekken_ongeremd")
    private int maxMassaTrekkenOngeremd;

    @SodaField("maximum_trekken_massa_geremd")
    private int maxTrekkenMassaGeremd;

    @SodaField("retrofit_roetfilter")
    private String retrofitRoetfilter;

    @SodaField("zuinigheidslabel")
    private String zuinigheidsLabel;

    @SodaField("datum_eerste_toelating")
    private int datumEersteToelating;

    @SodaField("datum_eerste_afgifte_nederland")
    private int datumEersteAfgifteNL;

    @SodaField("wacht_op_keuren")
    private String wachtOpKeuren;

    @SodaField("catalogusprijs")
    private int catalogusprijs;

    @SodaField("wam_verzekerd")
    private String wamVerzekerd;

    @SodaField("laadvermogen")
    private int laadvermogen;

    @SodaField("aanhangwagen_autonoom_geremd")
    private int aanwagenAutonoomGeremd;

    @SodaField("aantal_deuren")
    private int aantalDeuren;

    @SodaField("aantal_wielen")
    private int aantalWielen;

    @SodaField("afstand_hart_koppeling_tot_achterzijde_voertuig")
    private int afstandHartAchterzijde;

    @SodaField("afstand_voorzijde_voertuig_tot_hart_koppeling")
    private int afstandVoorzijdeHart;

    @SodaField("afwijkende_maximum_snelheid")
    private int afwijkendeMaxSnelheid;

    @SodaField("lengte")
    private int lengte;

    @SodaField("breedte")
    private int breedte;

    @SodaField("europese_voertuigcategorie")
    private String europeeseVoertuigcategorie;

    @SodaField("plaats_chassisnummer")
    private String plaatsChassisnummer;

    @SodaField("technische_max_massa_voertuig")
    private int technischeMaxMassaVoertuig;

    @SodaField("type")
    private String type;

    @SodaField("variant")
    private String variant;

    @SodaField("uitvoering")
    private String uitvoering;

    @SodaField("vermogen_massarijklaar")
    private int vermogenMassarijklaar;

    @SodaField("wielbasis")
    private int wielbasis;

    @SodaField("export_indicator")
    private String exportIndicator;

    @SodaField("openstaande_terugroepactie_indicator")
    private String terugroepactie;

    @SodaField("maximum_massa_samenstelling")
    private int maxMassaSamenstelling;

    @SodaField("maximum_ondersteunende_snelheid")
    private int maxOndersteundeSnelheid;

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public String getVoertuigsoort() {
        return voertuigsoort;
    }

    public void setVoertuigsoort(String voertuigsoort) {
        this.voertuigsoort = voertuigsoort;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getHandelsbenaming() {
        return handelsbenaming;
    }

    public void setHandelsbenaming(String handelsbenaming) {
        this.handelsbenaming = handelsbenaming;
    }

    public int getVervaldatumApk() {
        return vervaldatumApk;
    }

    public void setVervaldatumApk(int vervaldatumApk) {
        this.vervaldatumApk = vervaldatumApk;
    }

    public int getDatumTenaamstelling() {
        return datumTenaamstelling;
    }

    public void setDatumTenaamstelling(int datumTenaamstelling) {
        this.datumTenaamstelling = datumTenaamstelling;
    }

    public int getBrutoBpm() {
        return brutoBpm;
    }

    public void setBrutoBpm(int brutoBpm) {
        this.brutoBpm = brutoBpm;
    }

    public String getInrichting() {
        return inrichting;
    }

    public void setInrichting(String inrichting) {
        this.inrichting = inrichting;
    }

    public int getAantalZitplaatsen() {
        return aantalZitplaatsen;
    }

    public void setAantalZitplaatsen(int aantalZitplaatsen) {
        this.aantalZitplaatsen = aantalZitplaatsen;
    }

    public String getEersteKleur() {
        return eersteKleur;
    }

    public void setEersteKleur(String eersteKleur) {
        this.eersteKleur = eersteKleur;
    }

    public String getTweedeKleur() {
        return tweedeKleur;
    }

    public void setTweedeKleur(String tweedeKleur) {
        this.tweedeKleur = tweedeKleur;
    }

    public int getAantalCilinders() {
        return aantalCilinders;
    }

    public void setAantalCilinders(int aantalCilinders) {
        this.aantalCilinders = aantalCilinders;
    }

    public int getCilinderInhoud() {
        return cilinderInhoud;
    }

    public void setCilinderInhoud(int cilinderInhoud) {
        this.cilinderInhoud = cilinderInhoud;
    }

    public int getMassaLedigVoertuig() {
        return massaLedigVoertuig;
    }

    public void setMassaLedigVoertuig(int massaLedigVoertuig) {
        this.massaLedigVoertuig = massaLedigVoertuig;
    }

    public int getToegestaneMaxMassaVoertuig() {
        return toegestaneMaxMassaVoertuig;
    }

    public void setToegestaneMaxMassaVoertuig(int toegestaneMaxMassaVoertuig) {
        this.toegestaneMaxMassaVoertuig = toegestaneMaxMassaVoertuig;
    }

    public int getMassaRijklaar() {
        return massaRijklaar;
    }

    public void setMassaRijklaar(int massaRijklaar) {
        this.massaRijklaar = massaRijklaar;
    }

    public int getMaxMassaTrekkenOngeremd() {
        return maxMassaTrekkenOngeremd;
    }

    public void setMaxMassaTrekkenOngeremd(int maxMassaTrekkenOngeremd) {
        this.maxMassaTrekkenOngeremd = maxMassaTrekkenOngeremd;
    }

    public int getMaxTrekkenMassaGeremd() {
        return maxTrekkenMassaGeremd;
    }

    public void setMaxTrekkenMassaGeremd(int maxTrekkenMassaGeremd) {
        this.maxTrekkenMassaGeremd = maxTrekkenMassaGeremd;
    }

    public String getRetrofitRoetfilter() {
        return retrofitRoetfilter;
    }

    public void setRetrofitRoetfilter(String retrofitRoetfilter) {
        this.retrofitRoetfilter = retrofitRoetfilter;
    }

    public String getZuinigheidsLabel() {
        return zuinigheidsLabel;
    }

    public void setZuinigheidsLabel(String zuinigheidsLabel) {
        this.zuinigheidsLabel = zuinigheidsLabel;
    }

    public int getDatumEersteToelating() {
        return datumEersteToelating;
    }

    public void setDatumEersteToelating(int datumEersteToelating) {
        this.datumEersteToelating = datumEersteToelating;
    }

    public int getDatumEersteAfgifteNL() {
        return datumEersteAfgifteNL;
    }

    public void setDatumEersteAfgifteNL(int datumEersteAfgifteNL) {
        this.datumEersteAfgifteNL = datumEersteAfgifteNL;
    }

    public String getWachtOpKeuren() {
        return wachtOpKeuren;
    }

    public void setWachtOpKeuren(String wachtOpKeuren) {
        this.wachtOpKeuren = wachtOpKeuren;
    }

    public int getCatalogusprijs() {
        return catalogusprijs;
    }

    public void setCatalogusprijs(int catalogusprijs) {
        this.catalogusprijs = catalogusprijs;
    }

    public String getWamVerzekerd() {
        return wamVerzekerd;
    }

    public void setWamVerzekerd(String wamVerzekerd) {
        this.wamVerzekerd = wamVerzekerd;
    }

    public int getLaadvermogen() {
        return laadvermogen;
    }

    public void setLaadvermogen(int laadvermogen) {
        this.laadvermogen = laadvermogen;
    }

    public int getAanwagenAutonoomGeremd() {
        return aanwagenAutonoomGeremd;
    }

    public void setAanwagenAutonoomGeremd(int aanwagenAutonoomGeremd) {
        this.aanwagenAutonoomGeremd = aanwagenAutonoomGeremd;
    }

    public int getAantalDeuren() {
        return aantalDeuren;
    }

    public void setAantalDeuren(int aantalDeuren) {
        this.aantalDeuren = aantalDeuren;
    }

    public int getAantalWielen() {
        return aantalWielen;
    }

    public void setAantalWielen(int aantalWielen) {
        this.aantalWielen = aantalWielen;
    }

    public int getAfstandHartAchterzijde() {
        return afstandHartAchterzijde;
    }

    public void setAfstandHartAchterzijde(int afstandHartAchterzijde) {
        this.afstandHartAchterzijde = afstandHartAchterzijde;
    }

    public int getAfstandVoorzijdeHart() {
        return afstandVoorzijdeHart;
    }

    public void setAfstandVoorzijdeHart(int afstandVoorzijdeHart) {
        this.afstandVoorzijdeHart = afstandVoorzijdeHart;
    }

    public int getAfwijkendeMaxSnelheid() {
        return afwijkendeMaxSnelheid;
    }

    public void setAfwijkendeMaxSnelheid(int afwijkendeMaxSnelheid) {
        this.afwijkendeMaxSnelheid = afwijkendeMaxSnelheid;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public int getBreedte() {
        return breedte;
    }

    public void setBreedte(int breedte) {
        this.breedte = breedte;
    }

    public String getEuropeeseVoertuigcategorie() {
        return europeeseVoertuigcategorie;
    }

    public void setEuropeeseVoertuigcategorie(String europeeseVoertuigcategorie) {
        this.europeeseVoertuigcategorie = europeeseVoertuigcategorie;
    }

    public String getPlaatsChassisnummer() {
        return plaatsChassisnummer;
    }

    public void setPlaatsChassisnummer(String plaatsChassisnummer) {
        this.plaatsChassisnummer = plaatsChassisnummer;
    }

    public int getTechnischeMaxMassaVoertuig() {
        return technischeMaxMassaVoertuig;
    }

    public void setTechnischeMaxMassaVoertuig(int technischeMaxMassaVoertuig) {
        this.technischeMaxMassaVoertuig = technischeMaxMassaVoertuig;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getUitvoering() {
        return uitvoering;
    }

    public void setUitvoering(String uitvoering) {
        this.uitvoering = uitvoering;
    }

    public int getVermogenMassarijklaar() {
        return vermogenMassarijklaar;
    }

    public void setVermogenMassarijklaar(int vermogenMassarijklaar) {
        this.vermogenMassarijklaar = vermogenMassarijklaar;
    }

    public int getWielbasis() {
        return wielbasis;
    }

    public void setWielbasis(int wielbasis) {
        this.wielbasis = wielbasis;
    }

    public String getExportIndicator() {
        return exportIndicator;
    }

    public void setExportIndicator(String exportIndicator) {
        this.exportIndicator = exportIndicator;
    }

    public String getTerugroepactie() {
        return terugroepactie;
    }

    public void setTerugroepactie(String terugroepactie) {
        this.terugroepactie = terugroepactie;
    }

    public int getMaxMassaSamenstelling() {
        return maxMassaSamenstelling;
    }

    public void setMaxMassaSamenstelling(int maxMassaSamenstelling) {
        this.maxMassaSamenstelling = maxMassaSamenstelling;
    }

    public int getMaxOndersteundeSnelheid() {
        return maxOndersteundeSnelheid;
    }

    public void setMaxOndersteundeSnelheid(int maxOndersteundeSnelheid) {
        this.maxOndersteundeSnelheid = maxOndersteundeSnelheid;
    }
}
