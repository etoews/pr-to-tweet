(ns tweet.core
  (:require
    [clojure.edn :as edn]))

(defn load-twitter-config
  "Load and return your Twitter configuration.
   Copy twitter.edn.template to twitter.edn and edit."
  ([] (load-twitter-config "resources/twitter.edn"))
  ([filename]
  (try
    (edn/read-string (slurp filename))
    (catch java.io.FileNotFoundException e
      (throw (java.io.FileNotFoundException.
              (str (.getMessage e) " Copy twitter.edn.template to twitter.edn and edit.")))))))
