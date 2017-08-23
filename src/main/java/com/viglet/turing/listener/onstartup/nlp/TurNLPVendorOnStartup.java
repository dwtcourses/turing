package com.viglet.turing.listener.onstartup.nlp;

import com.viglet.turing.persistence.model.nlp.TurNLPVendor;
import com.viglet.turing.persistence.service.nlp.TurNLPVendorService;

public class TurNLPVendorOnStartup {

	public static void createDefaultRows() {


		TurNLPVendorService turNLPVendorService = new TurNLPVendorService();
		if (turNLPVendorService.listAll().isEmpty()) {
			
			TurNLPVendor turNLPVendor = new TurNLPVendor();
			turNLPVendor.setId("CORENLP");
			turNLPVendor.setDescription("Stanford CoreNLP");
			turNLPVendor.setPlugin("com.viglet.turing.plugins.corenlp.TurCoreNLPConnector");
			turNLPVendor.setTitle("Stanford CoreNLP");
			turNLPVendor.setWebsite("http://stanfordnlp.github.io/CoreNLP");
			turNLPVendorService.save(turNLPVendor);

			turNLPVendor = new TurNLPVendor();
			turNLPVendor.setId("OTCA");
			turNLPVendor.setDescription("OpenText OTCA");
			turNLPVendor.setPlugin("com.viglet.turing.plugins.otca.TurTMEConnector");
			turNLPVendor.setTitle("OpenText OTCA");
			turNLPVendor.setWebsite("http://opentext.com/what-we-do/products/discovery");
			turNLPVendorService.save(turNLPVendor);

			turNLPVendor = new TurNLPVendor();
			turNLPVendor.setId("OPENNLP");
			turNLPVendor.setDescription("Apache OpenNLP");
			turNLPVendor.setPlugin("com.viglet.turing.plugins.opennlp.TurOpenNLPConnector");
			turNLPVendor.setTitle("Apache OpenNLP");
			turNLPVendor.setWebsite("https://opennlp.apache.org");
			turNLPVendorService.save(turNLPVendor);
			
			turNLPVendor = new TurNLPVendor();
			turNLPVendor.setId("SPACY");
			turNLPVendor.setTitle("SpaCy");
			turNLPVendor.setPlugin(null);
			turNLPVendor.setDescription("SpaCy");
			turNLPVendor.setWebsite("https://spacy.io");
			turNLPVendorService.save(turNLPVendor);
			
			turNLPVendor = new TurNLPVendor();
			turNLPVendor.setId("NTLK");
			turNLPVendor.setTitle("NTLK");
			turNLPVendor.setPlugin(null);
			turNLPVendor.setDescription("NTLK");
			turNLPVendor.setWebsite("http://www.nltk.org");
			turNLPVendorService.save(turNLPVendor);
			
			turNLPVendor = new TurNLPVendor();
			turNLPVendor.setId("SYNTAXNET");
			turNLPVendor.setTitle("Google SyntaxNet");
			turNLPVendor.setPlugin(null);
			turNLPVendor.setDescription("Google SyntaxNet");
			turNLPVendor.setWebsite("https://www.tensorflow.org/versions/master/tutorials/syntaxnet/index.html");
			turNLPVendorService.save(turNLPVendor);
			
			turNLPVendor = new TurNLPVendor();
			turNLPVendor.setId("MALLET");
			turNLPVendor.setTitle("MALLET");
			turNLPVendor.setPlugin(null);
			turNLPVendor.setDescription("MALLET");
			turNLPVendor.setWebsite("http://mallet.cs.umass.edu");
			turNLPVendorService.save(turNLPVendor);
			
			turNLPVendor = new TurNLPVendor();
			turNLPVendor.setId("CLEARNLP");
			turNLPVendor.setTitle("ClearNLP");
			turNLPVendor.setPlugin(null);
			turNLPVendor.setDescription("ClearNLP");
			turNLPVendor.setWebsite("http://www.clearnlp.com");
			turNLPVendorService.save(turNLPVendor);
			
			turNLPVendor = new TurNLPVendor();
			turNLPVendor.setId("VIGLETNLP");
			turNLPVendor.setTitle("VigletNLP");
			turNLPVendor.setPlugin(null);
			turNLPVendor.setDescription("VigletNLP");
			turNLPVendor.setWebsite("http://www.viglet.ai");
			turNLPVendorService.save(turNLPVendor);
			
		}
	}

}