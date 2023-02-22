package com.qinweizhao.basic.tool.svn;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 * @author qinweizhao
 * @since 2022-06-10
 */
public class SvnTest {

    public static void main(String[] args) throws SVNException {
        //Set up connection protocols support:
        //http:// and https://
        DAVRepositoryFactory.setup();
        //svn://, svn+xxx:// (svn+ssh:// in particular)
        SVNRepositoryFactoryImpl.setup();
        //file:///
        FSRepositoryFactory.setup();
        String url = "http://10.200.47.151/svn/javaprojects/";
        String name = "qinweizh1ao";
        String password = "qinweizhao";
        SVNRepository repository = null;
        try {
            repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));
            ISVNAuthenticationManager authManager =
                    SVNWCUtil.createDefaultAuthenticationManager(name, password.toCharArray());
            repository.setAuthenticationManager(authManager);
        } catch (SVNException e) {
            e.printStackTrace();
            System.exit(1);
        }
        repository.testConnection();

    }
}
