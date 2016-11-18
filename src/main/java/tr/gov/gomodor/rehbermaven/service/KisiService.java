package tr.gov.gomodor.rehbermaven.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.gomodor.rehbermaven.entity.Kisi;
import tr.gov.gomodor.rehbermaven.facade.KisiFacade;

@Stateless
public class KisiService {
    
    @EJB
    private KisiFacade kisiFacade;
    
    public void ekle(Kisi p_kisi){
        
        kisiFacade.create(p_kisi);
        
    }
    
    public List<Kisi> kisileriGetir(){
        
        return kisiFacade.findAll();
        
    }
    
}
