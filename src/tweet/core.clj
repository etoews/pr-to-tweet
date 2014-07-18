(ns tweet.core
  (:require
    [clojure.edn :as edn]
    [clojure.java.io :as io]
    [twitter.oauth :refer :all]
    [twitter.callbacks :refer :all]
    [twitter.callbacks.handlers :refer :all]
    [twitter.api.restful :refer :all])
  (:import
    (twitter.callbacks.protocols SyncSingleCallback)))

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
