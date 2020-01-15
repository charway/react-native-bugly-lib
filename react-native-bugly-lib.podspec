require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = package["name"]
  s.version      = package["version"]
  s.summary      = package["description"]
  s.description  = <<-DESC
                  react-native-bugly-lib
                   DESC
  s.homepage     = "https://github.com/charway/react-native-bugly-lib"
  s.license      = "MIT"
  # s.license    = { :type => "MIT", :file => "FILE_LICENSE" }
  s.authors      = { "charway" => "charway@qq.com" }
  s.platforms    = { :ios => "9.0" }
  s.source       = { :git => "https://github.com/github_account/react-native-bugly-lib.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,m,swift}"
  s.requires_arc = true

  s.frameworks = 'SystemConfiguration'
  s.dependency "React"
  s.dependency "Bugly"
  # ...
  # s.dependency "..."
end

