package com.bbva.e2e;

import com.bbva.e2e.model.ApxTransactionResume;
import com.bbva.e2e.model.ApxTransactionResumeJson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import com.bbva.e2e.DroolsFactory;

public class CategorizeTest {

    private static final String INTENSIVO = "INTENSIVO";
    private static final String ALTO = "ALTO";
    private static final String MODERADO = "MODERADO";
    private static final String BAJO = "BAJO";
    private static final String RESIDUAL = "RESIDUAL";

    private static final String ACEPTADA = "ACEPTADA";
    private static final String OPTIMIZABLE = "OPTIMIZABLE";
    private static final String RECHAZADA = "RECHAZADA";


    private KieSession kSession;

    @Before
    public void setup() {
        Resource resource = ResourceFactory.newClassPathResource("com/bbva/e2e/ApxTransactionCategory.xlsx", getClass());
        kSession = new DroolsFactory().getKieSession(resource);
        System.out.println(new DroolsFactory().getDrlFromExcel("com/bbva/e2e/ApxTransactionCategory.xlsx"));
    }

    @Test
    public void testIntensivo(){

        ApxTransactionResumeJson apxTransactionResumeJson = getApxTransResume(3601L, 200L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(INTENSIVO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(ACEPTADA,apxTransactionResumeJson.getEstatus());

        apxTransactionResumeJson = getApxTransResume(3601L, 201L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(INTENSIVO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(OPTIMIZABLE,apxTransactionResumeJson.getEstatus());

        apxTransactionResumeJson = getApxTransResume(3601L, 401L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(INTENSIVO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(RECHAZADA,apxTransactionResumeJson.getEstatus());
    }

    @Test
    public void testAlto(){
        ApxTransactionResumeJson apxTransactionResumeJson = getApxTransResume(1001L, 399L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(ALTO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(ACEPTADA,apxTransactionResumeJson.getEstatus());

        apxTransactionResumeJson = getApxTransResume(1001L, 401L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(ALTO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(OPTIMIZABLE,apxTransactionResumeJson.getEstatus());

        apxTransactionResumeJson = getApxTransResume(1001L, 801L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(ALTO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(RECHAZADA,apxTransactionResumeJson.getEstatus());

    }

    @Test
    public void testModerado(){
        ApxTransactionResumeJson apxTransactionResumeJson = getApxTransResume(301L, 799L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(MODERADO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(ACEPTADA,apxTransactionResumeJson.getEstatus());

        apxTransactionResumeJson = getApxTransResume(301L, 801L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(MODERADO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(OPTIMIZABLE,apxTransactionResumeJson.getEstatus());

        apxTransactionResumeJson = getApxTransResume(301L, 1501L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(MODERADO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(RECHAZADA,apxTransactionResumeJson.getEstatus());
    }

    @Test
    public void testBajo(){
        ApxTransactionResumeJson apxTransactionResumeJson = getApxTransResume(41L, 1500L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(BAJO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(ACEPTADA,apxTransactionResumeJson.getEstatus());

        apxTransactionResumeJson = getApxTransResume(41L, 1501L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(BAJO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(OPTIMIZABLE,apxTransactionResumeJson.getEstatus());

        apxTransactionResumeJson = getApxTransResume(41L, 5001L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(BAJO,apxTransactionResumeJson.getUso());
        Assert.assertEquals(RECHAZADA,apxTransactionResumeJson.getEstatus());
    }

    @Test
    public void testResidual(){
        ApxTransactionResumeJson apxTransactionResumeJson = getApxTransResume(1L, 1500L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(RESIDUAL,apxTransactionResumeJson.getUso());
        Assert.assertEquals(ACEPTADA,apxTransactionResumeJson.getEstatus());

        apxTransactionResumeJson = getApxTransResume(1L, 5000L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(RESIDUAL,apxTransactionResumeJson.getUso());
        Assert.assertEquals(OPTIMIZABLE,apxTransactionResumeJson.getEstatus());

        apxTransactionResumeJson = getApxTransResume(1L, 5001L);
        kSession.insert(apxTransactionResumeJson);
        kSession.fireAllRules();
        Assert.assertEquals(RESIDUAL,apxTransactionResumeJson.getUso());
        Assert.assertEquals(RECHAZADA,apxTransactionResumeJson.getEstatus());
    }

    /**
     * Generate a ApxTransactionResumeJson object with the paremeters for drools test
     * @param maxEjecuciones
     * @param avgTime
     * @return
     */
    private ApxTransactionResumeJson getApxTransResume(Long maxEjecuciones, Long avgTime){
        ApxTransactionResume apxTransactionResume = new ApxTransactionResume();
        apxTransactionResume.setMaxejecuciones(maxEjecuciones);
        apxTransactionResume.setAvgtime(avgTime);
        return new ApxTransactionResumeJson(apxTransactionResume);
    }
}
