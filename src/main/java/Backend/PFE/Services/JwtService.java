package Backend.PFE.Services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import  Backend.PFE.Util.jwtUtil;
import Backend.PFE.Entities.JwtRequest;
import Backend.PFE.Entities.JwtResponse;
import Backend.PFE.Entities.Utilisateur;
import Backend.PFE.Repositories.UtilisateurRepository;
@Service
public class JwtService implements UserDetailsService{
	   @Autowired
	    private jwtUtil jwtUtil;

	    @Autowired
	    private UtilisateurRepository utilisateurRepository;
	    @Autowired
	    private AuthenticationManager authenticationManager;

	    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
	        String email = jwtRequest.getEmail();
	        String motPasse = jwtRequest.getMotPasse();
	        authenticate(email, motPasse);

	       UserDetails userDetails = loadUserByUsername(email);
	        String newGeneratedToken = jwtUtil.generateToken(userDetails);

	        Utilisateur user = utilisateurRepository.findById(email).get();
	        return new JwtResponse(user, newGeneratedToken);
	    }
	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Utilisateur user = utilisateurRepository.findById(email).get();

	        if (user != null) {
	            return new org.springframework.security.core.userdetails.User(
	                    user.getEmail(),
	                    user.getMotPasse(),
	                    getAuthority(user)
	            );
	        } else {
	            throw new UsernameNotFoundException("User not found with username: " + email);
	        }
	        
	    }
	        private Set<SimpleGrantedAuthority> getAuthority(Utilisateur user) {
	            Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	            
	                authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));
	           
	            return authorities;
	        }
	    
	    private void authenticate(String email, String motPasse) throws Exception {
	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, motPasse));
	        } catch (DisabledException e) {
	            throw new Exception("USER_DISABLED", e);
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }
	    }
}
