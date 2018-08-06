var config = manager.createConfig(manager.getFile("test", "config.yml"), 2);

config.set("test", true);
config.save();