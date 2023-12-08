package fr.m2.archi.et.services.manager;

import fr.m2.archi.et.model.UserLeadDto;
import org.apache.catalina.User;

import java.util.ArrayList;

public class CRMManager {

    static private CRMManager instance;
    ArrayList<UserLeadDto> usersAfterQuery;

    public static CRMManager Instance()
    {
        if(instance == null)
        {
            instance = new CRMManager();
        }
        return instance;
    }

    public CRMManager()
    {
        usersAfterQuery = new ArrayList<>();
    }

    public ArrayList<UserLeadDto> getUser(String nom, String prenom)
    {
        ArrayList<UserLeadDto> users = new ArrayList<UserLeadDto>();
        String nomComplet = prenom + " " + nom;
        for(UserLeadDto uld : usersAfterQuery)
        {
            String nomCompletULD = uld.getInformations().getFirstName() + " " + uld.getInformations().getLastName();
            if(nomComplet.equals(nomCompletULD))
            {
                users.add(uld);
            }
        }
        return users;
    }

    public boolean pasDeDoublons(ArrayList<UserLeadDto> usersToCheck)
    {

    }

    public ArrayList<UserLeadDto> getUniqueUsers()
    {
        ArrayList<UserLeadDto> uniqueUsers = new ArrayList<UserLeadDto>();

        for(UserLeadDto uld : usersAfterQuery)
        {
            boolean unique = true;
            for(UserLeadDto uuld : uniqueUsers)
            {
                if(uld.isEqual(uuld))
                {
                    unique = false;
                }
            }
            if(unique)
            {
                uniqueUsers.add(uld);
            }
        }
        return uniqueUsers;
    }

}
