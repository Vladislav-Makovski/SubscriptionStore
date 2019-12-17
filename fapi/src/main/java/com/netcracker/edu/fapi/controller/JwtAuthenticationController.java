package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.AdvertiserDataService;
import com.netcracker.edu.fapi.service.CustomerDataService;
import com.netcracker.edu.fapi.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.netcracker.edu.fapi.service.JwtUserDetailsService;

import com.netcracker.edu.fapi.config.JwtTokenUtil;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private UserInformationService userInformationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private CustomerDataService customerDataService;

    @Autowired
    private AdvertiserDataService advertiserDataService;

    @RequestMapping(value = "api/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails user = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        UserDetailsViewModel userInformation = userInformationService.getUserByUsername(authenticationRequest.getUsername());
//        возвращать ещё и информациюкакую то
        if(userInformation.getUserRoleId()== 1 || userInformation.getUserRoleId() == 3){
            UserSignatureViewModel userSignature = customerDataService.getCustomerByUserDetailsId(userInformation.getId());
            if(userInformation.getUserRoleId()== 1){
                return ResponseEntity.ok(new JwtResponse(token,userSignature.getId(),userInformation.getId(),userSignature.getWalletId(),"customer"));
            }else {
                return ResponseEntity.ok(new JwtResponse(token, userSignature.getId(), userInformation.getId(), userSignature.getWalletId(),"admin"));
            }
        }else{
            AdvertiserViewModel advertiser = advertiserDataService.getAdvertiserByUserDetailsId(userInformation.getId());
            return ResponseEntity.ok(new JwtResponse(token,advertiser.getId(),userInformation.getId(),advertiser.getWalletId(),"advertiser"));

            }
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
