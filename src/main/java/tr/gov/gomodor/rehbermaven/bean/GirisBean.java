package tr.gov.gomodor.rehbermaven.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.NoResultException;
import tr.gov.gomodor.rehbermaven.entity.Giris;
import tr.gov.gomodor.rehbermaven.service.GirisService;
import tr.gov.gomodor.rehbermaven.util.JSFUtil;

@ManagedBean
@RequestScoped
public class GirisBean {

    private Giris giris = new Giris();

    @EJB
    private GirisService girisService;

    public GirisBean() {

    }

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }

    public String giriseYetkilimi() {

        boolean sonuc = girisService.giriseYetkilimi(giris);

        if (sonuc) {

            return "menu.xhtml?faces-redirect=true";

        } else {

            JSFUtil.hataGoster("Hatalı Giriş", "Kullanıcı Adı ya da Şifre Yanlış!");
            return "giris.xhtml?faces-redirect=true";

        }

    }

}
